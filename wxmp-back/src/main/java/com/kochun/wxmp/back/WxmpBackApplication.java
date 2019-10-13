package com.kochun.wxmp.back;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/***
 * // 项目启动类
 * //由于项目加载其他依赖，需要对包进行扫描
 * @author kochun
 * @date 2019/8/29 19:29
 **/
@SpringBootApplication
@ComponentScan({"com.kochun.wxmp"})
public class WxmpBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(WxmpBackApplication.class, args);
    }

}
