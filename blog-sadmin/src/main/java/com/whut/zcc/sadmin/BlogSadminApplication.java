package com.whut.zcc.sadmin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.whut.zcc.sadmin.dao")
//@EnableEurekaClient
@SpringBootApplication
public class BlogSadminApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogSadminApplication.class, args);
    }

}
