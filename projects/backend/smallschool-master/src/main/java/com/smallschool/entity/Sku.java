package com.smallschool.entity;

import java.awt.*;

public class Sku {
    private Integer sku_id;
    private Integer spu_id;
    private Integer color_id;
    private Integer size_id;
    private Integer respository;

    private Color color;
    private Size size;

    public Sku() {
    }

    public Sku(Integer sku_id, Integer spu_id, Integer color_id, Integer size_id, Integer respository, Color color,
               Size size) {
        this.sku_id = sku_id;
        this.spu_id = spu_id;
        this.color_id = color_id;
        this.size_id = size_id;
        this.respository = respository;
        this.color = color;
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
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

    public Integer getColor_id() {
        return color_id;
    }

    public void setColor_id(Integer color_id) {
        this.color_id = color_id;
    }

    public Integer getSize_id() {
        return size_id;
    }

    public void setSize_id(Integer size_id) {
        this.size_id = size_id;
    }

    public Integer getRespository() {
        return respository;
    }

    public void setRespository(Integer respository) {
        this.respository = respository;
    }

    @Override
    public String toString() {
        return "Sku{" +
                "sku_id=" + sku_id +
                ", spu_id=" + spu_id +
                ", color_id=" + color_id +
                ", size_id=" + size_id +
                ", respository=" + respository +
                ", color=" + color +
                ", size=" + size +
                '}';
    }
}
