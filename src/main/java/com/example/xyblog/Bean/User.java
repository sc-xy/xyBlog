package com.example.xyblog.Bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
* author: 某洋
* description: 用户实体类
*/

@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    // 用户id
    private Long id;
    // 用户昵称
    private String nickName;
    // 用户账号
    private String userName;
    // 用户密码
    private String passWord;
    // 用户邮箱
    private String email;
    // 用户头像
    private String avatar;
    // 用户是否作者
    private boolean isAdmin;
    // 用户创建时间
    private Date createTime;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ",nickName='" + nickName + '\'' +
                ",userName='" + userName + '\'' +
                ",passWord='" + passWord + '\'' +
                ",email='" + email + '\'' +
                ",avatar='" + avatar + '\'' +
                ",isAdmin=" + isAdmin +
                ",createTime=" + createTime +
                '}';
    }

}
