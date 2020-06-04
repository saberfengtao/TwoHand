package com.ft;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.ft.mapper")
public class TwoHandApplication {


    public static void main(String[] args) {
        SpringApplication.run(TwoHandApplication.class, args);
    }

}
