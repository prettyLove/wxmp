package com.kochun.wxmp.back.service.system.impl;
import com.kochun.wxmp.back.service.system.EmailService;
import com.kochun.wxmp.back.service.system.SystemConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Map;
import java.util.Properties;

/**
 * @Description:
 * @Author: kochun
 * @Date: 2019-08-26 16:02
 * @version: 1.0
 */
@Service
@Slf4j
public class EmailServiceImpl implements EmailService {

    @Resource
    private SystemConfigService systemConfigService;


    /**
     * 发送邮件
     *
     * @param email
     * @param content
     * @param subject
     */
    @Override
    public void sendEmail(String email, String content, String subject) {
        try {
            Map<String, String> config = systemConfigService.getAllConfigs();
            Properties props = new Properties();
            //存储发送邮件服务器的信息
            props.put("mail.smtp.host", config.get("MAIL_SMTP_HOST"));
            //同时通过验证
            props.put("mail.smtp.auth", "true");
            Session session = Session.getDefaultInstance(props);
            Message message = new MimeMessage(session);
            //设置发件人
            message.setFrom(new InternetAddress(config.get("SEND_EMAIL_USERNAME")));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
            message.setSubject(subject);
            message.setContent(content, "text/html;charset=utf-8");
            Transport transport = session.getTransport("smtp");
            transport.connect(config.get("MAIL_SMTP_HOST"), config.get("SEND_EMAIL_USERNAME"), config.get("MAIL_SMTP_PASSWORD"));
            log.info("send ...");
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
