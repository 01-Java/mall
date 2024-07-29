package com.smallschool.entity;

public class Color {
    private Integer color_id;
    private String color_value;

    public Color() {
    }

    public Color(Integer color_id, String color_value) {
        this.color_id = color_id;
        this.color_value = color_value;
    }

    public Integer getColor_id() {
        return color_id;
    }

    public void setColor_id(Integer color_id) {
        this.color_id = color_id;
    }

    public String getColor_value() {
        return color_value;
    }

    public void setColor_value(String color_value) {
        this.color_value = color_value;
    }

    @Override
    public String toString() {
        return "Color{" +
                "color_id=" + color_id +
                ", value='" + color_value + '\'' +
                '}';
    }
}
