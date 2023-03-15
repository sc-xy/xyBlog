package com.example.xyblog.Queryvo;

import lombok.Data;

// 推荐博客
@Data
public class RecommendBlog {
    // 博客id
    private Long id;
    // 博客标题
    private String title;
    // 博客图片
    private String picture;
    // 是否被推荐
    private boolean recommend;

    @Override
    public String toString() {
        return "RecommendBlog{" +
                "id=" + id +
                ",title='" + title + '\'' +
                ",picture='" + picture + '\'' +
                ",recommend=" + recommend +
                '}';
    }
}
