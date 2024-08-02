package com.smallschool.mapper;

import com.smallschool.entity.ProductDetails;
import com.smallschool.entity.ProductRecommend;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HomaPageMapper {

    @Select("SELECT * FROM recommend ")
    List<ProductRecommend> homeRecommend();

    @Select("SELECT * FROM recommend WHERE style=#{style}")
    List<ProductRecommend> homeByCategory(String style);

    //ditails 和 picture多表查询
    @Select("SELECT d.product_id, p2.price, p.imageUrl, d.style\n" +
            "FROM details d\n" +
            "JOIN picture p ON d.product_id = p.product_id\n" +
            "LEFT JOIN product p2 ON d.product_id = p2.product_id\n" +
            "WHERE d.style LIKE CONCAT('%', #{name}, '%');")
    List<ProductRecommend> homeSearch(String name);
}
