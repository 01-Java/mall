package com.smallschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
* 订单详情页面
* 实现
* 1、获取订单列表
* 2、删除订单
* 3、更改订单
*
* */
@Controller
@RequestMapping("/orderDetail")
public class OrderDetailsController {
    public String getOrder(){

        return "example";
    }

    public String deleteOrder(){

        return "example";
    }
    public String changeOrder(){

        return "example";
    }
}
