package com.koreait.facebook.user;

import com.koreait.facebook.user.model.UserEntity;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    HttpSession session;

    public int join(UserEntity param){
        String hashPw = BCrypt.hashpw(param.getPw(), BCrypt.gensalt());
        param.setPw(hashPw);
        return userMapper.join(param);
    }

}
