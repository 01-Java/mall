package com.smallschool.mapper;


import com.smallschool.entity.LoginPageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* @author HUAWEI
* @description 针对表【user_info】的数据库操作Mapper
* @createDate 2024-07-29 13:56:10
* @Entity smallschool.entity.LoginPageInfo
*/
@Mapper
public interface LoginPageInfoMapper{

    //注册
    /**
     * 查询是否存在某账号
     */
    LoginPageInfo FindUserById(Integer userId);

    /**
     * 把注册的账号信息传入数据库
     */
    void InputUserInfo(LoginPageInfo loginPageInfo);

    //登录
    /**
     * 查询传入账号的密码
     */
    LoginPageInfo FindPasswordById(Integer userId);

    //注销
    /**
     * 根据id删除user_info中的信息
     */
    void DeleteUserInfoById(Integer userId);

    //找回密码
    /**
     * 根据传入电话号码和账号查询对应密码
     */
    LoginPageInfo FindUserByIdAndPhone(@Param("user_id") Integer userId, @Param("phone") String phone);
}




