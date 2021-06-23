package com.koreait.facebook.security;

import com.koreait.facebook.user.UserMapper;
import com.koreait.facebook.user.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = new UserEntity();
        user.setEmail(email);
        UserEntity loginUser = userMapper.selUser(user);
        if(loginUser == null){
            return null;
        }
        return new UserDetailImpl(loginUser); //아이디 있는상태 로그인이 되는상태는 아님
    }
}
