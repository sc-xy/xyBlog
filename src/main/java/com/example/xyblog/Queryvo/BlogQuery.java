package com.example.xyblog.Queryvo;

import com.example.xyblog.Bean.Type;
import lombok.Data;

import java.util.Date;

// 显示博客实体
@Data
public class BlogQuery {
    // 博客id
    private Long id;
    // 博客标题
    private String title;
    // 更新时间
    private Date updateTime;
    // 是否推荐
    private boolean recommend;
    // 分类id
    private Long typeId;
    // 分类
    private Type type;

    @Override
    public String toString() {
        return "BlogQuery{" +
                "id=" + id +
                ",title='" + title + '\'' +
                ",updateTime=" + updateTime +
                ",recommend=" + recommend +
                ",typeId=" + typeId +
                ",type='" + type + '\'' +
                '}';
    }
}
