package com.smallschool.entity;

public class Cart {
    private Integer cart_id;

    private Integer user_id;

    private Integer product_id;

    private Integer sku_id;

    private Integer product_number;

    private DATETIME add_time;

    public Cart() {
    }

    public Cart(Integer cart_id, Integer user_id, Integer product_id, Integer sku_id, Integer product_number, DATETIME add_time) {
        this.cart_id = cart_id;
        this.user_id = user_id;
        this.product_id = product_id;
        this.sku_id = sku_id;
        this.product_number = product_number;
        this.add_time = add_time;
    }

    public Integer getCart_id() {
        return cart_id;
    }

    public void setCart_id(Integer cart_id) {
        this.cart_id = cart_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Integer getSku_id() {
        return sku_id;
    }

    public void setSku_id(Integer sku_id) {
        this.sku_id = sku_id;
    }

    public Integer getProduct_number() {
        return product_number;
    }

    public void setProduct_number(Integer product_number) {
        this.product_number = product_number;
    }

    public DATETIME getAdd_time() {
        return add_time;
    }

    public void setAdd_time(DATETIME add_time) {
        this.add_time = add_time;
    }
}