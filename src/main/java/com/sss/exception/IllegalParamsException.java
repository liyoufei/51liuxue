package com.sss.exception;

/**
 * IllegalParamsException class
 *
 * @author Sss
 * @date 2019/3/28
 */
public class IllegalParamsException extends RuntimeException implements WithTypeException {


    private Type type;

    public IllegalParamsException(Type type,String msg){

        super(msg);
        this.type = type;
    }

    public Type type(){
        return type;
    }

    public enum Type{
        /**
         * 错误的页码
         */
        WRONG_PAGE_NUM,
        /**
         * 错误的类型
         */
        WRONG_TYPE
    }
}
