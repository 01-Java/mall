package com.smallschool.entity;

public class Sloper {

    private Integer sloper_id;
    private String type;

    public Sloper() {
    }

    public Sloper(Integer sloper_id, String type) {
        this.sloper_id = sloper_id;
        this.type = type;
    }

    public Integer getSloper_id() {
        return sloper_id;
    }

    public void setSloper_id(Integer sloper_id) {
        this.sloper_id = sloper_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Sloper{" +
                "sloper_id=" + sloper_id +
                ", type='" + type + '\'' +
                '}';
    }
}
