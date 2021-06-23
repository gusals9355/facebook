package com.koreait.facebook.user;

import com.koreait.facebook.user.model.UserEntity;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public void login(UserEntity userEntity, Model model){

    }

    @GetMapping("/join")
    public void join(UserEntity userEntity){

    }
    @PostMapping("/join")
    public String joinP(UserEntity param){
        userService.join(param);

        return "redirect:login?needEmail=1";
    }

    @GetMapping("/auth")
    public String auth(UserEntity param){
        int result = userService.auth(param);
        return "redirect:login?auth="+result;
    }

    @GetMapping("profile")
    public void profile(){

    }
    @PostMapping("profileImg")
    public String profileImg(MultipartFile[] files){

        return "redirect:profile";
    }

}
