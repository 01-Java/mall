package com.smallschool.entity;

public class Spu {
    private Integer spu_id;
    private Integer brand_id;
    private Integer details_id;
    private Integer sloper_id;
    private Integer is_active;
    private String product_name;
    private String description;
    private Brand brand;
    private ProductDetails productDetails;
    private Sloper sloper;

    public Spu() {
    }

    @Override
    public String toString() {
        return "Spu{" +
                "spu_id=" + spu_id +
                ", brand_id=" + brand_id +
                ", details_id=" + details_id +
                ", sloper_id=" + sloper_id +
                ", is_active=" + is_active +
                ", name='" + product_name + '\'' +
                ", description='" + description + '\'' +
                ", brand=" + brand +
                ", productDetails=" + productDetails +
                ", sloper=" + sloper +

                '}';
    }



    public Spu(Integer spu_id, Integer brand_id, Integer details_id, Integer sloper_id, Integer is_active, String product_name,
               String description, Brand brand, ProductDetails productDetails, Sloper sloper) {
        this.spu_id = spu_id;
        this.brand_id = brand_id;
        this.details_id = details_id;
        this.sloper_id = sloper_id;
        this.is_active = is_active;
        this.product_name = product_name;
        this.description = description;
        this.brand = brand;
        this.productDetails = productDetails;
        this.sloper = sloper;

    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public ProductDetails getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(ProductDetails productDetails) {
        this.productDetails = productDetails;
    }

    public Sloper getSloper() {
        return sloper;
    }

    public void setSloper(Sloper sloper) {
        this.sloper = sloper;
    }

    public Integer getSpu_id() {
        return spu_id;
    }

    public void setSpu_id(Integer spu_id) {
        this.spu_id = spu_id;
    }

    public Integer getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(Integer brand_id) {
        this.brand_id = brand_id;
    }

    public Integer getDetails_id() {
        return details_id;
    }

    public void setDetails_id(Integer details_id) {
        this.details_id = details_id;
    }

    public Integer getSloper_id() {
        return sloper_id;
    }

    public void setSloper_id(Integer sloper_id) {
        this.sloper_id = sloper_id;
    }

    public Integer getIs_active() {
        return is_active;
    }

    public void setIs_active(Integer is_active) {
        this.is_active = is_active;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
