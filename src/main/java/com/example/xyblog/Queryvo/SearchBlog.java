package com.example.xyblog.Queryvo;

import lombok.Data;

import java.util.Date;

// 搜索博客列表
@Data
public class SearchBlog {
    // 博客id
    private Long id;
    // 博客标题
    private String title;
    // 博客时间
    private Date updateTime;
    // 博客类别
    private Long typeId;

    @Override
    public String toString() {
        return "SearchBlog{" +
                "id=" + id +
                ",title='" + title + '\'' +
                ",updateTime=" + updateTime +
                "typeId=" + typeId +
                '}';
    }
}
