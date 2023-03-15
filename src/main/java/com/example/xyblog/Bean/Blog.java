package com.example.xyblog.Bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * author: 某洋
 * description: 博客实体类
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Blog {
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
    // 是否推荐博客
    private boolean recommend;
    // 博客类别
    private Integer typeId;
    // 博客描述
    private String description;
    // 博客评论
    private List<Comment> comments = new ArrayList<>();

    @Override
    public String toString() {
        return "DetailedBlog{" +
                "id=" + id + '\'' +
                ",picture='" + picture + '\'' +
                ",title='" + title + '\'' +
                ",content='" + content + '\'' +
                ",views=" + views +
                ",commentCount=" + commentCount +
                ",update_time=" + updateTime +
                ",commentable=" + commentable +
                ",recommend=" + recommend +
                ",typeId=" + typeId +
                ",description='" + description + '\'' +
                ",comments='" + comments + '\'' +
                '}';

    }

}
