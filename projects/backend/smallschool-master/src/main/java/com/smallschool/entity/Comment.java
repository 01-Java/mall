package com.smallschool.entity;

import java.time.LocalDateTime;

public class Comment {
    private Integer comment_id;
    private String content;
    private Integer product_id;
    private Integer user_id;//加
    private LocalDateTime time;

    private PersonalInfo personalInfo;//加

    public Comment() {
    }

    public Comment(Integer comment_id, String content, Integer product_id, Integer user_id, LocalDateTime time, PersonalInfo personalInfo) {
        this.comment_id = comment_id;
        this.content = content;
        this.product_id = product_id;
        this.user_id = user_id;
        this.time = time;
        this.personalInfo = personalInfo;
    }

    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getComment_id() {
        return comment_id;
    }

    public void setComment_id(Integer comment_id) {
        this.comment_id = comment_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }


    @Override
    public String toString() {
        return "Comment{" +
                "comment_id=" + comment_id +
                ", content='" + content + '\'' +
                ", product_id=" + product_id +
                ", user_id=" + user_id +
                ", time=" + time +
                ", personalInfo=" + personalInfo +
                '}';
    }
}
