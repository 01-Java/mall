package com.smallschool.service;

import com.smallschool.entity.Comment;
import com.smallschool.mapper.ProductDetailsMapper;
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
}
