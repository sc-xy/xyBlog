package com.example.xyblog.Bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Picture {
    // 图片id
    private Long id;
    // 图片名
    private String name;
    // 图片地址
    private String address;

    @Override
    public String toString() {
        return "Picture{" +
                "id=" + id +
                ",name='" + name + '\'' +
                ",address='" + address + '\'' +
                '}';
    }
}
