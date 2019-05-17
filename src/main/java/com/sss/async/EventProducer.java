package com.sss.async;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sss.util.JedisAdapter;
import com.sss.util.RedisKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventProducer {

    @Autowired
    JedisAdapter jedisAdapter;

    public boolean fireEvent(EventModel eventModel){

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(eventModel);
            String key = RedisKeyUtil.getBizEventqueue();

            jedisAdapter.lpush(key,json);
            return true;

        }catch (Exception e){
            return false;
        }
    }
}
