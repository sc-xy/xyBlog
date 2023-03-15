package com.example.xyblog.Queryvo;

import lombok.Data;

import java.util.Date;

// 博客详情实体
@Data
public class DetailedBlog {
    // 博客id
    private Long id;
    // 博客图片
    private String picture;
    // 博客标题
    private String title;
    // 博客内容
    private String content;
    // 博客浏览数目
    private Integer views;
    // 评论数目
    private Integer commentCount;
    // 更新时间
    private Date updateTime;
    // 是否可以评论
    private boolean commentable;
    // 博客类别
    private String typeName;

    @Override
    public String toString() {
        return "DetailedBlog{" +
                "id=" + id + '\'' +
                ",picture='" + picture + '\'' +
                ",title='" + title + '\'' +
                ",content='" + content + '\'' +
                ",views=" + views +
                ",commentCount=" + commentCount +
                ",Date=" + updateTime +
                ",commentable=" + commentable +
                ",typeName='" + typeName + '\'' +
                '}';

    }


}
