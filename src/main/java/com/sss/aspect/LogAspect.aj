package com.sss.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public aspect LogAspect {

    private Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Before("execution(* com.sss.controller.*Controller.*(..))")
    public void beforeMethod(JoinPoint joinPoint){
        StringBuilder stringBuilder = new StringBuilder();
        for(Object arg : joinPoint.getArgs()){
            stringBuilder.append("arg: "+arg.toString()+"|");
        }
        logger.info("Before "+stringBuilder.toString());

    }

    @After("execution(* com.sss.controller.*Controller.*(..))")
    public void afterMethod(){
        logger.info("After "+new Date().toString());
    }

}
