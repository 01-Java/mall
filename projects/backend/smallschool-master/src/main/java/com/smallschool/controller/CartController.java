package com.smallschool.controller;

import com.smallschool.service.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {
    /*
    * 1、获取购物车信息
    * 2、添加到购物车
    * 3、购物车移除
    * 4、购物车下单
    * */
    @Autowired
    private CartService cartService;

    @GetMapping("/cartinfo")
    public List<Cart> getCart(@RequestParam Integer user_id){
        return cartService.getCartByUid(user_id);
    }
    @RequestMapping("{cart_id}/num/add")
    public JsonResult<Integer> addNum(@PathVariable("cid") Integer cart_id) {
        Integer data = cartService.addCart(cart_id);
        return new JsonResult<Integer>(OK, data);
    }
    @DeleteMapping("{cart_id}/num/delete")
    public JsonResult<Integer> deleteNum(@PathVariable("cid") Integer cart_id) {
        Integer data = cartService.deleteCart(cart_id);
        return new JsonResult<Integer>(OK, data);
    }
    @PostMapping("/cartcheckout")
    public List<Cart> payCart(@RequestBody Integer cart_id){
        return cartService.payCart(cart_id);
    }
}
