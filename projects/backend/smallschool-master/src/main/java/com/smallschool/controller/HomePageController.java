package com.smallschool.controller;

import com.smallschool.entity.ProductDetails;
import com.smallschool.service.HomePageService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/*
*   商城主页面
*   1、推荐列表
*   2、分类列表
*   3、搜索（按照，模糊搜索均可）
* */
@Controller
@RequestMapping("/homePage")
public class HomePageController {
    @Autowired
    private HomePageService homePageService;

    @GetMapping("/recommend")
    public List<ProductDetails> getRecommend() {
        return homePageService.getRecommend();
    }
    @GetMapping("/category/{category}")
    public List<ProductDetails> getCategory(@PathVariable("category") String category) {
        return homePageService.getCategory(category);
    }
    @GetMapping("/search")
    public List<ProductDetails> getSearch(@RequestParam String name) {
        return homePageService.getSearch(name);
    }
}
