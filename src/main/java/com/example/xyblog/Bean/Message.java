package com.example.xyblog.Bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Message {
    // 留言id
    private Long id;
    // 留言邮箱
    private String email;
    // 留言昵称
    private String nickName;
    // 留言内容
    private String content;
    // 留言头像
    private String avatar;
    // 留言时间
    private Date createTime;
    // 父留言id
    private Long parentMessageId;
    // 父留言昵称, 用于@使用
    private String parentNickName;
    // 是否管理员留言
    private boolean adminMessage;
    // 回复留言
    private List<Message> replyMessages = new ArrayList<>();
    // 父留言
    private Message parentMessage;

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ",email='" + email + '\'' +
                ",nickName='" + nickName + '\'' +
                ",content='" + content + '\'' +
                ",avatar='" + avatar + '\'' +
                ",createTime=" + createTime +
                ",parentMessageId='" + parentMessageId + '\'' +
                ",parentNickName='" + parentNickName + '\'' +
                ",adminMessage=" + adminMessage + '\'' +
                ",replyMessages='" + replyMessages + '\'' +
                "parentMessage='" + parentMessage + '\'' +
                '}';

    }


}
