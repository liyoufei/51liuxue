package com.sss.service;

import com.google.common.collect.ImmutableMap;
import com.sss.async.EventModel;
import com.sss.async.EventProducer;
import com.sss.async.EventType;
import com.sss.common.ResultMsg;
import com.sss.dao.UserMapper;
import com.sss.exception.UserException;
import com.sss.model.User;
import com.sss.model.UserDetail;
import com.sss.util.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * UserService class
 *
 * @author Sss
 * @date 2019/3/26
 */
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserDetailService userDetailService;

    @Autowired
    EventProducer eventProducer;

    @Autowired
    JedisAdapter jedisAdapter;

    @Autowired
    MailService mailService;


    /**
     * 用户填写表单信息进行注册
     * @param user
     * @return
     */
    public ResultMsg register(User user) {
        User account = getUserByEmail(user.getEmail());
        if(account != null){
            return ResultMsg.errorMsg("此邮箱已经被注册");
        }else if(getUserByName(user.getName()) != null){
            return ResultMsg.errorMsg("此用户名已经被注册");
        }else {
            String password = HashUtil.encryPassword(user.getPassword());
            user.setPassword(password);
            user.setSalt(HashUtil.SALT);
            BeanHelper.onInsert(user);
            user.setAvatarUrl("http://127.0.0.1:8081/1545649869/IMG_3052.JPG");
            user.setStatus(new Byte("0"));
            if(addAccount(user) == 1){
                EventModel eventModel = new EventModel(EventType.REGISTER);
                eventModel.setEntityOwnerId(user.getUserId());
                eventProducer.fireEvent(eventModel);
                return ResultMsg.successMsg("成功注册（未认证）");
            }else {
                return ResultMsg.errorMsg("注册失败");
            }

        }
    }

    /**
     * 发送用户激活邮件，里边包含唯一的识别链接
     * @param email 用户邮件
     */
    public void registerNotify(String email){
        String randomKey = HashUtil.encryText(email) + RandomStringUtils.randomAlphabetic(10);
        jedisAdapter.set(randomKey,email);
        //设置过期时间为10分钟
        jedisAdapter.expire(randomKey,600);
        String content = DataUtil.ENABLE_URL + "?key=" + randomKey;
        mailService.sendMail(email,"激活邮件",content);

    }

    /**
     * 用户点击连接进行认证，超时则失效
     * @param key 邀请邮件中的key
     * @return
     */
    public User enable(String key){
        String email = jedisAdapter.get(key);
        if(StringUtils.isBlank(email)){
            throw new UserException(UserException.Type.USER_NOT_FOUND,"无效的key");
        }
        User updateUser = getUserByEmail(email);
        updateUser.setStatus(new Byte("1"));
        userMapper.updateByEmail(updateUser);
        UserDetail userDetail = new UserDetail();
        userDetail.setUserId(updateUser.getUserId());
        userDetailService.insertDetail(userDetail);
        return updateUser;

    }

    /**
     * 认证登录
     * @param email
     * @param password
     * @return
     */
    public User auth(String email, String password) {

        if(StringUtils.isBlank(email) || StringUtils.isBlank(password)){
            throw new UserException(UserException.Type.USER_AUTH_FAIL,"User Auth Fail");
        }

        User retUser = getUserByEmail(email);
        if(retUser != null){
            if(HashUtil.encryPassword(password).equals(retUser.getPassword()) && retUser.getStatus() != 0){
                onLogin(retUser);
                return retUser;
            }
        }
        throw new UserException(UserException.Type.USER_AUTH_FAIL,"User Auth Fail");

    }

    /**
     * 登录的时候获得token将token设置为user属性
     * @param retUser
     */
    private void onLogin(User retUser) {
        String token = JwtHelper.genToken(ImmutableMap.of("email", retUser.getEmail(),"name", retUser.getName(),"ts", Instant.now().toString()));
        renewToken(retUser.getEmail(),token);
        //设置为属性
        retUser.setToken(token);
    }

    /**
     * 每次登录时将token延时
     * @param email
     * @param token
     * @return
     */
    private String renewToken(String email,String token){
        jedisAdapter.set(email,token);
        jedisAdapter.expire(email,24*60*60);
        return token;
    }

    /**
     * 用于进行登陆的用户认证
     * @param token
     * @return
     */
    public User getLoginedUser(String token) {
        Map<String,String> map = null;

        try{
            map = JwtHelper.verifyToken(token);
            String email = map.get("email");
            long expire = jedisAdapter.getExpire(email);
            if(expire > 0L){
                User user = getUserByEmail(email);
                user.setToken(token);
                return user;
            }
            throw new UserException(UserException.Type.USER_NOT_LOGIN,"User not login");

        }catch(Exception e){
            throw new UserException(UserException.Type.USER_NOT_LOGIN,"User not login");
        }

    }

    /**
     * 可用于注销登录
     * @param token cookie中的token值
     */
    public void invalidate(String token){
        Map<String,String> map = JwtHelper.verifyToken(token);
        jedisAdapter.delete(map.get("email"));
    }

    /**
     * 将用户成功添加至数据库
     * @param user
     */
    public int addAccount(User user){

        return userMapper.insert(user);
    }

    public User getUserByEmail(String email) {
        return userMapper.selectByEmail(email);

    }

    public User getUserByName(String name){
        return userMapper.selectByName(name);
    }


    public User getUserById(int userId) {
        return userMapper.selectByPrimaryKey(userId);
    }
}
