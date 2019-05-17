package com.sss.async;

public enum EventType {
    LIKE(0),
    COMMENT(1),
    REGISTER(4),
    LOGIN(2),
    MAIL(3);

    private int value;
    EventType(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }

}
