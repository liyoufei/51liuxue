package com.sss.common;

import com.sss.model.User;
import org.springframework.stereotype.Component;

/**
 * HostHolder class
 *
 * @author Sss
 * @date 2019/3/26
 */
@Component
public class UserContext {

    //threadlocal为每个线程保存一个变量副本，都能读而不存在线程不安全的问题
    private static ThreadLocal<User> users = new ThreadLocal<>();

    public static void setUser(User user){
        users.set(user);
    }

    public static User getUser(){
        return users.get();
    }

    public  static  void clear(){
        users.remove();
    }
}
