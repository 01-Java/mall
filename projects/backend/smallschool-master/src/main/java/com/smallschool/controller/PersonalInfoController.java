package com.smallschool.controller;

import com.smallschool.service.PersonalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
*     用户信息页面
* 1、获取个人信息
* 2、修改个人信息
* 3、修改头像
* */
@RestController
@RequestMapping("/personalInfo")
public class PersonalInfoController {
    @Autowired
    private PersonalInfoService personalInfoService;

    @RequestMapping("/selectAll")
    public String selectAll(){
        return personalInfoService.selectAll().toString();
    }

    public void changeInfo(){

    }

    public void changePic(){

    }
}
