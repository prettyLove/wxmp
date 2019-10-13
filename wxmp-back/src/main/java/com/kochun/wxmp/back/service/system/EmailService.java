package com.kochun.wxmp.back.service.system;

/**
 * @Description:
 * @Author: kochun
 * @Date: 2019-08-26 16:00
 * @version: 1.0
 */
public interface EmailService {
    /**
     * 发送邮件
     * @param email
     * @param content
     */
    void sendEmail(String email, String content, String subject);
}
