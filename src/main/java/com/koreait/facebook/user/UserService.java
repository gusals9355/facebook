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
        String rVal = mySecurityUtils.getRandomValue1(5);
        String hashPw = BCrypt.hashpw(param.getPw(), BCrypt.gensalt());
        param.setPw(hashPw);
        param.setAuthCd(rVal);

        int result = userMapper.join(param);
        if(result == 1){
            String subject = "[얼굴책] 인증메일입니다.";
            String txt = String.format("<a href=\"http://localhost:8081/user/auth?email=%s&authCd=%s\">인증하기</a>"
                    , param.getEmail(), rVal);
            emailService.sendMimeMessage(param.getEmail(),subject,txt);
        }
        return result;
    }

    public int auth(UserEntity param){
        return userMapper.upAuth(param);
    }


}
