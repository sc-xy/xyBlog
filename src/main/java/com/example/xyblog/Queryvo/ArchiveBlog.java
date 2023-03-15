package com.example.xyblog.Queryvo;

import lombok.Data;

import java.util.Date;

// 归档博客
@Data
public class ArchiveBlog {
    // 博客id
    private Long id;
    // 博客标题
    private String title;
    // 更新时间
    private Date updateTime;

    @Override
    public String toString() {
        return "ArchiveBlog{" +
                "id=" + id +
                ",title='" + title + '\'' +
                ",updateTime=" + updateTime +
                '}';
    }
}
