package com.kochun.wxmp.back;

import com.kochun.wxmp.back.shiro.PasswordHelper;
import com.kochun.wxmp.back.shiro.AesCipherUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.sql.ResultSet;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WxmpBackApplicationTests {

    @Resource
    PasswordHelper passwordHelper;


    @Resource
    private AesCipherUtil aesCipherUtil;

    @Test
    public void contextLoads() {
        //System.out.println(passwordHelper.encryptPassword(null,"test"));
        System.out.println(AesCipherUtil.enCrypto("kochun"));
    }

}
