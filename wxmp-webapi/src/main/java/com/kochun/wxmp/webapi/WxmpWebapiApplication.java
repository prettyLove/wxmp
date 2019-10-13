package com.kochun.wxmp.webapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.kochun.wxmp"})
public class WxmpWebapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(WxmpWebapiApplication.class, args);
    }

}
