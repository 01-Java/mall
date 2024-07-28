package com.smallschool.entity;

public class Size {
    private Integer size_id;
    private String value;

    public Size() {
    }

    public Size(Integer size_id, String value) {
        this.size_id = size_id;
        this.value = value;
    }

    public Integer getSize_id() {
        return size_id;
    }

    public void setSize_id(Integer size_id) {
        this.size_id = size_id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Size{" +
                "size_id=" + size_id +
                ", value='" + value + '\'' +
                '}';
    }
}
