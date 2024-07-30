package com.smallschool.controller.login;

import com.smallschool.entity.LoginPageInfo;
import com.smallschool.entity.PersonalInfo;
import com.smallschool.entity.Result;
import com.smallschool.service.LoginPageInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/*
* 1、实现登录
* 2、实现注册
* 3、实现注销功能
* */
@Controller
@RequestMapping("/loginPage")
@CrossOrigin
public class LoginPageController {

    @Autowired
    private LoginPageInfoService loginPageInfoService;


    @PostMapping("/login")
    public Result login(Integer userId, String passWord){
        int i = loginPageInfoService.Login(userId,passWord);
        Result result = new Result();
        if(i == 1){
            return result.error("账号未注册！");
        }else if(i == 3){
            return result.success("注册成功！");
        }
        else{
            return result.error("密码错误");
        }
    }

    @PostMapping("/signup")
    public Result signup(LoginPageInfo loginPageInfo){
        int i = loginPageInfoService.Register(loginPageInfo);
        Result result = new Result();
        if(i == 1){
            return result.error("账号已存在，注册失败！");
        }else if(i == 2){
            return result.error("注册失败");
        }else{
            return result.success("注册成功！");
        }

    }

    @PostMapping("/logout")
    public Result logout(Integer userId) {
       int i = loginPageInfoService.Logout(userId);
       Result result = new Result();
       if(i == 1){
           return result.error("注销失败");
       }else if(i == 2){
           return result.error("注销失败");
       }else{
           return result.success("注销成功！");
       }
    }

    @PostMapping("/findPassword")
    public Result findPassword(Integer userId,String phone){
        String s = loginPageInfoService.FindPassword(userId,phone);
        Result result = new Result();
        if(s.equals("找不到密码!")){
            return result.error(s);
        }else{
            return result.success(s);
        }
    }
}
