package com.smallschool.entity;

public class Picture {
    private Integer picture_id;
    private Integer product_id;
    private String url;

    public Picture() {
    }

    public Picture(Integer picture_id, Integer product_id, String url) {
        this.picture_id = picture_id;
        this.product_id = product_id;
        this.url = url;
    }

    public Integer getPicture_id() {
        return picture_id;
    }

    public void setPicture_id(Integer picture_id) {
        this.picture_id = picture_id;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "picture{" +
                "picture_id=" + picture_id +
                ", product_id=" + product_id +
                ", url='" + url + '\'' +
                '}';
    }
}
