package com.koreait.facebook.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
public class EmailServiceImpl implements EmailService{

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendSimpleMessage(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom("asdasd@naver.com"); //보내는 사람 이메일
        message.setTo(to); //받는사람 이메일 주소
        message.setSubject(subject); //제목
        message.setText(text); //내용
        mailSender.send(message);
    }
    @Override
    public void sendMimeMessage(String to, String subject, String text){
        MimeMessage mimeMessage =  mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
//        message.setFrom("asdasd@naver.com"); //보내는 사람 이메일
        try {
            helper.setTo(to); //받는사람 이메일 주소
            helper.setSubject(subject);
            helper.setText(text, true); // true넣을 경우 html
            mailSender.send(mimeMessage);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
