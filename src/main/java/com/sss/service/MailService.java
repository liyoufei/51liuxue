package com.sss.service;

import com.sss.util.MailUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service
public class MailService {
    private static final Logger logger = LoggerFactory.getLogger(MailService.class);

    public boolean sendMail(String emailAddress,String subject,String content){
        try {
            JavaMailSenderImpl sender = MailUtil.getSender();
            MimeMessage message =  sender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(message);
            messageHelper.setFrom("1316188986@qq.com");
            messageHelper.setTo(emailAddress);
            messageHelper.setSubject(subject);
            messageHelper.setText(content);
            sender.send(message);
            return true;
        }catch (Exception e){
            logger.error("发送失败"+e.getMessage());
            return false;
        }

    }

}
