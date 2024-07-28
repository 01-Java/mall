package com.smallschool.entity;

public class Cart {
    private String cart_id;

    private String user_id;

    private String product_id;

    private String sku_id;

    private int product_number;

    private String add_time;

    public Cart() {
    }
    public Cart(String cart_id, String user_id, String product_id, String sku_id, int product_number, String add_time) {
        this.cart_id = cart_id;
        this.user_id = user_id;
        this.product_id = product_id;
        this.sku_id = sku_id;
        this.product_number = product_number;
        this.add_time = add_time;
    }

    public String getCart_id() {
        return cart_id;
    }

    public void setCart_id(String cart_id) {
        this.cart_id = cart_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getSku_id() {
        return sku_id;
    }

    public void setSku_id(String sku_id) {
        this.sku_id = sku_id;
    }

    public int getProduct_number() {
        return product_number;
    }

    public void setProduct_number(int product_number) {
        this.product_number = product_number;
    }

    public String getAdd_time() {
        return add_time;
    }

    public void setAdd_time(String add_time) {
        this.add_time = add_time;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Cart{" +
                "cart_id='" + cart_id + '\'' +
                ", user_id='" + user_id + '\'' +
                ", product_id='" + product_id + '\'' +
                ", sku_id='" + sku_id + '\'' +
                ", product_number=" + product_number +
                ", add_time='" + add_time + '\'' +
                '}';
    }
}
