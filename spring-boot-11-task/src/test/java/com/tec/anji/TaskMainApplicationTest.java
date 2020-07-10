package com.tec.anji;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TaskMainApplicationTest {

    @Autowired
    private JavaMailSender mailSender;

    @Test
    public void sendSimpleMail() {
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setFrom("825877689@qq.com");
        mailMessage.setTo("wangxinquan@anji-tec.com");

        mailMessage.setSubject("【MEB立库】现场调试");
        mailMessage.setText("7/13 - 7/17：预调试");

        mailSender.send(mailMessage);
    }

    @Test
    public void sendComplexMail() throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);

        messageHelper.setFrom("825877689@qq.com");
        messageHelper.setTo("wangxinquan@anji-tec.com");

        messageHelper.setSubject("【MEB立库】现场调试");
        messageHelper.setText("<b>7/13 - 7/17</b>：预调试", true);
        messageHelper.addAttachment("小样.jpg", new File("C:\\Users\\admin\\Pictures\\小样.jpg"));

        mailSender.send(mimeMessage);
    }
}
