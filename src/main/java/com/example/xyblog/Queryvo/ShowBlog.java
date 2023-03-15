package com.example.xyblog.Queryvo;

import lombok.Data;

import java.util.Date;

@Data
public class ShowBlog {
    // 博客id
    private Long id;
    // 博客标题
    private String title;
    // 博客内容
    private String content;
    // 博客类别id
    private Long typeId;
    // 博客图片
    private String picture;
    // 博客描述
    private String description;
    // 是否推荐
    private boolean recommend;
    // 是否可评论
    private boolean commentable;
    // 更新时间
    private Date updateTime;

    @Override
    public String toString() {
        return "ShowBlog{" +
                "id=" + id +
                ",title='" + title + '\'' +
                ",content='" + content + '\'' +
                ",typeId=" + typeId +
                ",picture='" + picture + '\'' +
                ",description='" + description + '\'' +
                ",recommend=" + recommend +
                ",commentable=" + commentable +
                ",updateTime=" + updateTime +
                '}';
    }
}
