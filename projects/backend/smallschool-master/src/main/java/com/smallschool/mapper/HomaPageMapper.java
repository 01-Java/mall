package com.smallschool.mapper;

import com.smallschool.entity.ProductDetails;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HomaPageMapper {

    @Select("SELECT * FROM products WHERE sales>50")
    List<ProductDetails> homeRecommend();

    @Select("SELECT * FROM details WHERE style=#{style}")
    List<ProductDetails> homeByCategory(String style);

    @Select("SELECT * FROM products WHERE name LIKE CONCAT('%',#{name},'%')")
    List<ProductDetails> homeSearch(String name);
}
