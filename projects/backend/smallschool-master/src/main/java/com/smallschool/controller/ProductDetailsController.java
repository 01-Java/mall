package com.smallschool.controller;

import com.smallschool.entity.Comment;
import com.smallschool.service.ProductDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/*
*        商品详情页面，较为复杂
* */
@RestController
@RequestMapping("/productDetails")
public class ProductDetailsController {

    @Autowired
    private ProductDetailsService productDetailsService;
    @RequestMapping("/comments")
    public List<Map<String,Object>> getProductComments(Integer product_id){
//        System.out.println(product_id);
        List<Comment> commentsFromDB = productDetailsService.getProductComments(product_id);
//        System.out.println(commentsFromDB);
        List<Map<String, Object>> comments = new ArrayList<>();

        for (Comment comment : commentsFromDB) {
            Map<String, Object> commentInfo = new HashMap<>();
            commentInfo.put("userName",comment.getPersonalInfo().getName());
            commentInfo.put("content",comment.getContent());
            comments.add(commentInfo);
        }
        return comments;
    }

}
