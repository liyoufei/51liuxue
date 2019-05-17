package com.sss;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.sss.dao"}) //mapper的包
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
