package com.smallschool.service;

import com.smallschool.entity.Comment;
import com.smallschool.entity.Picture;
import com.smallschool.entity.Product;
import com.smallschool.entity.Sku;
import com.smallschool.mapper.ProductDetailsMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDetailsService {
    @Autowired
    private ProductDetailsMapper productDetailsMapper;

    public List<Comment> getProductComments(Integer product_id){
        return productDetailsMapper.getCommentsByProductId(product_id);
    }

    public boolean addComment(Comment comment){
        return productDetailsMapper.addComment(comment) > 0;
    }

    public List<Picture> getProductPicturesUrl(Integer product_id){
        return productDetailsMapper.getPicturesUrlByProductId(product_id);
    }

    public List<Product> getProductInfoExcludeSku(Integer product_id){
        return productDetailsMapper.getProductInfoExcludeSku(product_id);
    }

    public List<Product> getProductInfoIncludeSku(Integer product_id,Integer sku_id){
        return productDetailsMapper.getProductInfoIncludeSku(product_id,sku_id);
    }

    public boolean addCartRecord(Integer spu_id,Integer color_id , Integer size_id,Integer user_id,Integer product_id,
                                Integer product_number){
        Sku sku = productDetailsMapper.getSku(spu_id, color_id, size_id);

        if(sku == null){
            return false;
        }

        return productDetailsMapper.addCartRecord(user_id, product_id, sku.getSku_id(), product_number) >0;
    }

}
