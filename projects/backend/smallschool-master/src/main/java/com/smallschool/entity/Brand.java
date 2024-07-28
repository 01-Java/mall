package com.smallschool.entity;

public class Brand {
    private Integer brand_id;
    private String name;

    public Brand() {
    }

    public Brand(Integer brand_id, String name) {
        this.brand_id = brand_id;
        this.name = name;
    }

    public Integer getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(Integer brand_id) {
        this.brand_id = brand_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "brand_id=" + brand_id +
                ", name='" + name + '\'' +
                '}';
    }
}
