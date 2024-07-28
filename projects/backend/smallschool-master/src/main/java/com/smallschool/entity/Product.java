package com.smallschool.entity;

public class Product {
    private Integer product_id;
    private Integer sales;
    private Integer sku_id;
    private Integer spu_id;
    private Double price;

    public Product() {
    }

    public Product(Integer product_id, Integer sales, Integer sku_id, Integer spu_id, Double price) {
        this.product_id = product_id;
        this.sales = sales;
        this.sku_id = sku_id;
        this.spu_id = spu_id;
        this.price = price;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Integer getSku_id() {
        return sku_id;
    }

    public void setSku_id(Integer sku_id) {
        this.sku_id = sku_id;
    }

    public Integer getSpu_id() {
        return spu_id;
    }

    public void setSpu_id(Integer spu_id) {
        this.spu_id = spu_id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + product_id +
                ", sales=" + sales +
                ", sku_id=" + sku_id +
                ", spu_id=" + spu_id +
                ", price=" + price +
                '}';
    }
}
