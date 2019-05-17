package com.sss.exception;

/**
 * UserException class
 *
 * @author Sss
 * @date 2019/3/28
 */
public class UserException extends RuntimeException implements WithTypeException {

    private Type type;

    public UserException(Type type,String message){
        super(message);
        this.type = type;
    }

    public enum Type{
        USER_NOT_LOGIN,USER_NOT_FOUND,USER_AUTH_FAIL;
    }

}
