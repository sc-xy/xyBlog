package com.example.xyblog.Queryvo;

import lombok.Data;

import java.util.Date;

// 首页数据实体
@Data
public class FirstPageBlog {
    // 博客id
    private Long id;
    // 博客标题
    private String title;
    // 博客图片
    private String picture;
    // 博客浏览次数
    private Integer views;
    // 博客评论数目
    private Integer commentCount;
    // 博客描述
    private String description;
    // 博客更新时间
    private Date updateTime;
    // 博客类别
    private String typeName;

    @Override
    public String toString() {
        return "FirstPageBlog{" +
                "id=" + id +
                ",title='" + title + '\'' +
                ",picture='" + picture + '\'' +
                ",views=" + views +
                ",commentCount=" + commentCount +
                ",description='" + description + '\'' +
                ",updateTime=" + updateTime +
                ",typeName='" + typeName + '\'' +
                '}';
    }
}
