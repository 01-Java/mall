package com.smallschool.service;

import com.smallschool.entity.LoginPageInfo;
import com.smallschool.mapper.LoginPageInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginPageInfoService {

    @Autowired
    private LoginPageInfoMapper loginPageInfoMapper;
    /**
     * 登录功能
     */
    public int Login(int userID,String password){
        LoginPageInfo loginPageInfo = loginPageInfoMapper.FindUserById(userID);

        //1.检查是否存在账号
        //2.检查账号对应密码是否正确
        if(loginPageInfo == null){
            return 1; //账号未注册
        }else if(loginPageInfo.getPassword().equals(password)){
            return 3;   //登录成功
        }else{
            return 2;      //密码错误
        }
    }

    /**
     * 注册功能
     */
    public int Register(LoginPageInfo loginPageInfo){
        //1.检查是否已经存在该账号，存在则注册失败，不存在则可以注册
        LoginPageInfo loginPageInfo1 = loginPageInfoMapper.FindUserById(loginPageInfo.getUserId());
        if(loginPageInfo1 == null){
            loginPageInfoMapper.InputUserInfo(loginPageInfo);
        }else{
            return 1;   //"账号已经存在，注册失败！"
        }
        //2.检查是否注册成功
        loginPageInfo1 = loginPageInfoMapper.FindUserById(loginPageInfo.getUserId());
        if(loginPageInfo1 == null){
            return 2 ;//"注册失败！"
        }else{
            return 3; //"注册成功！";
        }
    }

    /**
     * 注销功能
     */
    public int Logout(int userId){
        //1.账号是否存在
        LoginPageInfo loginPageInfo = loginPageInfoMapper.FindUserById(userId);
        if(loginPageInfo == null){
            return 1;//"注销失败!";
        }
        loginPageInfoMapper.DeleteUserInfoById(userId);
        if(loginPageInfo == null){
            return 3;//"注销成功!";
        }else{
            return 2;//"注销失败!";
        }
    }

    /**
     * 找回密码功能
     */
    public String FindPassword(Integer userId,String phone){
        //1.账号是否存在
       LoginPageInfo loginPageInfo = loginPageInfoMapper.FindUserByIdAndPhone(userId, phone);
       if(loginPageInfo == null){
           return "找不到密码";
       }else{
           return loginPageInfo.getPassword();
       }
    }

}
