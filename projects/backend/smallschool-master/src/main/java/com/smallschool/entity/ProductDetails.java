package com.smallschool.entity;

public class ProductDetails {
    private Integer details_id;
    private String suitable_people;
    private String suitable_season;
    private String suitable_scene;
    private String style;

    public ProductDetails() {
    }

    public ProductDetails(Integer details_id, String suitable_people, String suitable_season, String suitable_scene, String style) {
        this.details_id = details_id;
        this.suitable_people = suitable_people;
        this.suitable_season = suitable_season;
        this.suitable_scene = suitable_scene;
        this.style = style;
    }

    public Integer getDetails_id() {
        return details_id;
    }

    public void setDetails_id(Integer details_id) {
        this.details_id = details_id;
    }

    public String getSuitable_people() {
        return suitable_people;
    }

    public void setSuitable_people(String suitable_people) {
        this.suitable_people = suitable_people;
    }

    public String getSuitable_season() {
        return suitable_season;
    }

    public void setSuitable_season(String suitable_season) {
        this.suitable_season = suitable_season;
    }

    public String getSuitable_scene() {
        return suitable_scene;
    }

    public void setSuitable_scene(String suitable_scene) {
        this.suitable_scene = suitable_scene;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    @Override
    public String toString() {
        return "Details{" +
                "details_id=" + details_id +
                ", suitable_people='" + suitable_people + '\'' +
                ", suitable_season='" + suitable_season + '\'' +
                ", suitable_scene='" + suitable_scene + '\'' +
                ", style='" + style + '\'' +
                '}';
    }
}
