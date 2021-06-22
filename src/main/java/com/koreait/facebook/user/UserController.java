package com.koreait.facebook.user;

import com.koreait.facebook.user.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public void login(){

    }
    @GetMapping("/join")
    public void join(UserEntity userEntity){

    }
    @PostMapping("/join")
    public String joinP(UserEntity param){
        userService.join(param);

        return "redirect:/feed/home";
    }

    @GetMapping("/auth")
    public void auth(UserEntity param){
        userService.auth(param);
    }

}
