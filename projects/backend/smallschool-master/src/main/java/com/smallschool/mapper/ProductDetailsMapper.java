package com.smallschool.mapper;

import com.smallschool.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductDetailsMapper {

    /*
    *  根据商品Id查询关于该商品的评论
    *
    * */

    List<Comment> getCommentsByProductId(@Param("product_id") Integer product_id);


}
