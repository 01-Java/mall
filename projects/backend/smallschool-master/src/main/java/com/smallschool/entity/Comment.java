package com.smallschool.entity;

import java.time.LocalDateTime;

public class Comment {
    private Integer comment_id;
    private String content;
    private Integer product_id;
    private LocalDateTime time;

    public Comment() {
    }

    public Comment(Integer comment_id, String content, Integer product_id, LocalDateTime time) {
        this.comment_id = comment_id;
        this.content = content;
        this.product_id = product_id;
        this.time = time;
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
                ", time=" + time +
                '}';
    }
}
