package com.example.xyblog.Bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FriendLink {
    // 友链id
    private Long id;
    // 友链描述
    private String linkDes;
    // 友链地址
    private String linkAddress;
    // 友链图片
    private String avatar;

    @Override
    public String toString() {
        return "FriendLink{" +
                "id=" + id +
                ",linkDes='" + linkDes + '\'' +
                ",linkAddress='" + linkAddress + '\'' +
                ",avatar='" + avatar + '\'' +
                '}';
    }
}
