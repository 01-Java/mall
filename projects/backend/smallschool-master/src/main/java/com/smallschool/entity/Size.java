package com.smallschool.entity;

public class Size {
    private Integer size_id;
    private String size_value;

    public Size() {
    }

    public Size(Integer size_id, String size_value) {
        this.size_id = size_id;
        this.size_value = size_value;
    }

    public Integer getSize_id() {
        return size_id;
    }

    public void setSize_id(Integer size_id) {
        this.size_id = size_id;
    }

    public String getSize_value() {
        return size_value;
    }

    public void setSize_value(String size_value) {
        this.size_value = size_value;
    }

    @Override
    public String toString() {
        return "Size{" +
                "size_id=" + size_id +
                ", value='" + size_value + '\'' +
                '}';
    }
}
