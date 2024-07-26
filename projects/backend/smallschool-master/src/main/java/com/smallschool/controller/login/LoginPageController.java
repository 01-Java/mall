package com.smallschool.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
* 1、实现登录
* 2、实现注册
* 3、实现注销功能
* */
@Controller
@RequestMapping("/loginPage")
public class LoginPageController {
    public String login(){


        return "example";
    }
    public String signup(){


        return "example";
    }

    public String logout(){


        return "example";
    }
}
