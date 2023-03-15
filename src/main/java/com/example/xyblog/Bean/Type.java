package com.example.xyblog.Bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

// 分类实体类
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Type {
    // 类别id
    private Long id;

    // 类别名
    private String name;

    // 类别下的博客
    private List<Blog> blogs = new ArrayList<>();

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ",name='" + name + '\'' +
                ",blogs='" + blogs + '\'' +
                '}';
    }

}
