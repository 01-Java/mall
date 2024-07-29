package com.smallschool.controller;

import com.smallschool.entity.Comment;
import com.smallschool.entity.Picture;
import com.smallschool.entity.Product;
import com.smallschool.service.ProductDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
    @RequestMapping("/getComments")
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

    @RequestMapping("/addComment")
    public String addProductComments(@RequestBody Comment comment){
//        System.out.println(comment);
        if(!productDetailsService.addComment(comment)){
               return "评论失败....";
        }
        return "评论成功";
    }

    @RequestMapping("/getPicturesUrl")
    public List<String> getPicturesUrl(Integer product_id){
        ArrayList<String> url = new ArrayList<>();

        List<Picture> productPicturesUrl = productDetailsService.getProductPicturesUrl(product_id);

        for (Picture picture : productPicturesUrl) {
            url.add(picture.getUrl());
        }
        return url;
    }

    @RequestMapping("/getPicturesInfoExcludeSku")
    public List<Map<String,Object>> getPicturesInfoExcludeSku(Integer product_id){
//        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
//        System.out.println(product_id);
//        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        List<Product> productsFromDB = productDetailsService.getProductInfoExcludeSku(product_id);
//        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
//        System.out.println(productsFromDB);
//        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        List<Map<String, Object>> products = new ArrayList<>();
        for (Product product : productsFromDB) {
            Map<String, Object> productInfo = new HashMap<>();

            productInfo.put("product_id",product.getProduct_id());
            productInfo.put("product_name",product.getSpu().getProduct_name());
            productInfo.put("brand_name",product.getSpu().getBrand().getBrand_name());
            productInfo.put("Style",product.getSpu().getProductDetails().getStyle());
            productInfo.put("Suitable_people",product.getSpu().getProductDetails().getSuitable_people());
            productInfo.put("Suitable_scene",product.getSpu().getProductDetails().getSuitable_scene());
            productInfo.put("Suitable_season",product.getSpu().getProductDetails().getSuitable_season());
            productInfo.put("Type",product.getSpu().getSloper().getType());
            productInfo.put("Description",product.getSpu().getDescription());
            productInfo.put("Price",product.getPrice());
            productInfo.put("Sales",product.getSales());

            products.add(productInfo);
        }
        return products;
    }


    @RequestMapping("/getPicturesInfoIncludeSku")
    public List<Map<String,Object>> getPicturesInfoExcludeSku(Integer product_id,Integer sku_id){
//        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
//        System.out.println(product_id);
//        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        List<Product> productsFromDB = productDetailsService.getProductInfoIncludeSku(product_id,sku_id);
//        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
//        System.out.println(productsFromDB);
//        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        List<Map<String, Object>> products = new ArrayList<>();
        for (Product product : productsFromDB) {
            Map<String, Object> productInfo = new HashMap<>();

            productInfo.put("product_id",product.getProduct_id());
            productInfo.put("product_name",product.getSpu().getProduct_name());
            productInfo.put("brand_name",product.getSpu().getBrand().getBrand_name());
            productInfo.put("Style",product.getSpu().getProductDetails().getStyle());
            productInfo.put("Suitable_people",product.getSpu().getProductDetails().getSuitable_people());
            productInfo.put("Suitable_scene",product.getSpu().getProductDetails().getSuitable_scene());
            productInfo.put("Suitable_season",product.getSpu().getProductDetails().getSuitable_season());
            productInfo.put("Type",product.getSpu().getSloper().getType());
            productInfo.put("Description",product.getSpu().getDescription());
            productInfo.put("Price",product.getPrice());
            productInfo.put("Sales",product.getSales());
            productInfo.put("Size",product.getSku().getSize().getSize_value());
            productInfo.put("Color",product.getSku().getColor().getColor_value());
            productInfo.put("Respository",product.getSku().getRespository());

            products.add(productInfo);
        }
        return products;
    }

    @RequestMapping("/addCartRecord")
    public String addCartRecord(Integer spu_id,Integer color_id , Integer size_id,Integer user_id,Integer product_id,
                                Integer product_number){
        if(!productDetailsService.addCartRecord(spu_id,color_id,size_id,user_id,product_id,product_number)){
            return "加入购物车失败!";
        }

        return "加入购物车成功!";
    }

}
