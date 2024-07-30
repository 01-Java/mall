package com.smallschool.entity;

import java.time.LocalDateTime;

public class Order {
    private Integer order_id;
    private Integer status;
    private Integer user_id;
    private Integer product_id;
    private Integer product_number;
    private Double amount;
    private LocalDateTime order_time;
    private String address;
    private String phone;
    private String consignee;

    public Order() {
    }

    public Order(Integer order_id, Integer status, Integer user_id, Integer product_id, Integer product_number,
                 Double amount, LocalDateTime order_time, String address, String phone, String consignee) {
        this.order_id = order_id;
        this.status = status;
        this.user_id = user_id;
        this.product_id = product_id;
        this.product_number = product_number;
        this.amount = amount;
        this.order_time = order_time;
        this.address = address;
        this.phone = phone;
        this.consignee = consignee;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public Integer getProduct_number() {
        return product_number;
    }

    public void setProduct_number(Integer product_number) {
        this.product_number = product_number;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDateTime getOrder_time() {
        return order_time;
    }

    public void setOrder_time(LocalDateTime order_time) {
        this.order_time = order_time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", status=" + status +
                ", user_id=" + user_id +
                ", product_id=" + product_id +
                ", product_number=" + product_number +
                ", amount=" + amount +
                ", order_time=" + order_time +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", consignee='" + consignee + '\'' +
                '}';
    }
}
