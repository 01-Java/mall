package com.smallschool.entity;

//首页推荐商品

public class ProductRecommend {
    private Integer product_id;
    private Double price;
    private String imageUrl;
    private String style;

    public ProductRecommend(Integer productId, Double price, String imageUrl) {
        product_id = productId;
        this.price = price;
        this.imageUrl = imageUrl;
    }
    public ProductRecommend(){
    }

    public Double getPrice() {
        return price;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getStyle() {
        return style;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    @Override
    public String toString() {
        return "ProductRecommend{" +
                "product_id=" + product_id +
                ", price=" + price +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
