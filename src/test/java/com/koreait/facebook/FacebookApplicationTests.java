package com.koreait.facebook;

import com.koreait.facebook.common.EmailService;
import com.koreait.facebook.common.MySecurityUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.mail.MessagingException;

@SpringBootTest
class FacebookApplicationTests {

    @Autowired
    private EmailService email;
    @Autowired
    MySecurityUtils mySecurityUtils;
    @Test
    void sendEmail() throws MessagingException {
        String to = "gusals9355@naver.com";
        String subject = "subject";
        String txt = "content. <a href=\"http://localhost:8081/user/login\">로그인</a>";
        email.sendMimeMessage(to,subject,txt);
    }

    @Test
    void random(){
        System.out.println(mySecurityUtils.getRandomValue(36));
    }
    @Test
    void random1(){
        System.out.println(mySecurityUtils.getRandomValue1(16));
    }

}
