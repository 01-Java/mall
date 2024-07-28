package com.smallschool.controller;

import com.smallschool.service.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/cart")
public class CartController {
    /*
    * 1、获取购物车信息
    * 2、添加到购物车
    * 3、购物车移除
    * 4、购物车下单
    * */
    @GetMapping("/info")
    public ResponseEntity<String> getCart(@RequestParam String user_id){
        String cartInfo = cartService.getCartInfo(userId);
        return ResponseEntity.ok(cartInfo);
    }
    @PostMapping("/add")
    public ResponseEntity<String> addCart(@RequestBody String product_id){


        return ResponseEntity.status(HttpStatus.CREATED).body("Item added to cart successfully");
    }
    @DeleteMapping("/remove")
    public ResponseEntity<String> deleteCart(@RequestBody String product_id){


        return ResponseEntity.ok("Item removed from cart successfully");
    }
    @PostMapping("/checkout")
    public ResponseEntity<String> payCart(@RequestBody String orderInfo){


        return ResponseEntity.ok("Checkout and payment successful");
    }
}
