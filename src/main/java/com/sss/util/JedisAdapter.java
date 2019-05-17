package com.sss.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

/**
 * JedisAdapter class
 *
 * @author Sss
 * @date 2019/3/26
 */
@Service
public class JedisAdapter  implements InitializingBean {

    private static Logger logger = LoggerFactory.getLogger(JedisAdapter.class);
    private JedisPool jedisPool;

    @Override
    public void afterPropertiesSet() throws Exception {
        jedisPool = new JedisPool("redis://localhost:6379/10");
    }

    public long sadd(String key,String value){
        Jedis jedis = null;
        try{
            jedis = jedisPool.getResource();
            return jedis.sadd(key,value);

        }catch (Exception e){
            logger.error("添加失败"+e.getMessage());
        }finally{
            if(jedis != null){
                jedis.close();
            }
        }
        return 0;
    }

    public long srem(String key,String value){
        Jedis jedis = null;
        try{
            jedis = jedisPool.getResource();
            return jedis.srem(key,value);
        }catch (Exception e){
            logger.error("删除失败"+e.getMessage());
        }finally {
            if(jedis != null){
                jedis.close();
            }
        }
        return 0;
    }

    public long scard(String key){
        Jedis jedis = null;
        try{
            jedis = jedisPool.getResource();
            return jedis.scard(key);
        }catch (Exception e){
            logger.error("统计失败"+e.getMessage());
        }finally {
            if(jedis != null){
                jedis.close();
            }
        }

        return 0;
    }

    public boolean sismember(String key,String value){
        Jedis jedis = null;
        try{
            jedis = jedisPool.getResource();
            return jedis.sismember(key, value);
        }catch (Exception e){
            logger.error("判断是否包含出错"+e.getMessage());
        }finally {
            if(jedis != null){
                jedis.close();
            }
        }
        return false;
    }

    public long lpush(String key,String value){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.lpush(key,value);
        }catch (Exception e){
            logger.error("添加失败"+e.getMessage());
        }finally {
            if(jedis != null){
                jedis.close();
            }
        }

        return 0;
    }

    public List<String> brpop(int timeout, String key){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.brpop(timeout, key);
        }catch (Exception e){
            logger.error("提取事件失败"+e.getMessage());
        }finally {
            if(jedis != null){
                jedis.close();
            }
        }
        return null;
    }

    public String set(String key, String value){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.set(key,value);
        }catch (Exception e){
            logger.error("添加失败"+e.getMessage());
        }finally {
            if(jedis != null){
                jedis.close();
            }
        }
        return null;
    }
    public String get(String key){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.get(key);
        }catch (Exception e){
            logger.error("获取失败"+e.getMessage());
        }finally {
            if(jedis != null){
                jedis.close();
            }
        }
        return null;
    }

    public long expire(String key, int seconds){
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.expire(key,seconds);
        }catch (Exception e){
            logger.error("设置过期时间失败"+e.getMessage());
        }finally {
            if(jedis != null){
                jedis.close();
            }
        }
        return 0;
    }


    public long getExpire(String email) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.ttl(email);
        }catch (Exception e){
            logger.error("查询剩余时间失败"+e.getMessage());
        }finally {
            if(jedis != null){
                jedis.close();
            }
        }
        return 0L;
    }

    public Long delete(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.del(key);
        }catch (Exception e){
            logger.error("删除键失败"+e.getMessage());
        }finally {
            if(jedis != null){
                jedis.close();
            }
        }
        return 0L;
    }
}
