package com.smallschool.mapper;

import com.smallschool.entity.Comment;
import com.smallschool.entity.Picture;
import com.smallschool.entity.Product;
import com.smallschool.entity.Sku;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductDetailsMapper {

    /**
    *  根据商品Id查询关于该商品的评论
    * */
    List<Comment> getCommentsByProductId(@Param("product_id") Integer product_id);

    /**
    *  添加一条评论
    * */

    int addComment(Comment comment);

    /**
    *   根据商品Id查询关于该商品图片的路径
    * */

    List<Picture> getPicturesUrlByProductId(@Param("product_id") Integer product_id);

    /**
     *  根据商品Id查询关于该商品的详细信息（不包括sku属性）
     * */
    List<Product> getProductInfoExcludeSku(@Param("product_id") Integer product_id);

    /**
     *  根据商品Id查询关于该商品的详细信息（包括sku属性）
     * */
    List<Product> getProductInfoIncludeSku(@Param("product_id") Integer product_id,@Param("sku_id")Integer sku_id);

//    /**
//     *  获取color_id
//     *
//     * */
//
//    Integer getColorId(@Param("color_value")String color_value);
//    /**
//     *  获取size_id
//     *
//     * */
//    Integer getColorId(@Param("size_value")String size_value);
    /**
     *  根据选择获取sku
     *
     * */
    Sku getSku(@Param("spu_id") Integer spu_id, @Param("color_id") Integer color_id , @Param("size_id") Integer size_id );

    /**
     *  添加一条购物车记录
     * */
    int addCartRecord(@Param("user_id")Integer user_id,@Param("product_id")Integer product_id,
                      @Param("sku_id")Integer sku_id,@Param("product_number")Integer product_number);

    
}
