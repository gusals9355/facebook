package com.koreait.facebook.user;

import com.koreait.facebook.common.EmailService;
import com.koreait.facebook.common.EmailServiceImpl;
import com.koreait.facebook.common.MySecurityUtils;
import com.koreait.facebook.user.model.UserEntity;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserService {
    @Autowired
    private MySecurityUtils mySecurityUtils;
    @Autowired
    private EmailService emailService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private HttpSession session;

    public int join(UserEntity param){
        String rVal = mySecurityUtils.getRandomValue(5);
        String hashPw = BCrypt.hashpw(param.getPw(), BCrypt.gensalt());
        param.setPw(hashPw);
        param.setAuthCd(rVal);

        int result = userMapper.join(param);
    //ddd
        if(result == 1){

        }

        return result;
    }

    public void sendEmail(){
        String to = "gusals9355@naver.com";
        String subject = "subject";
        String txt = "content";
        emailService.sendSimpleMessage(to,subject,txt);
    }

}
