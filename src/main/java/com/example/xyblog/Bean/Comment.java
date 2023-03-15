package com.example.xyblog.Bean;

import com.example.xyblog.Queryvo.DetailedBlog;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Comment {
    // 评论id
    private Long id;
    // 评论邮箱
    private String email;
    // 评论昵称
    private String nickName;
    // 评论内容
    private String content;
    // 评论头像
    private String avatar;
    // 评论时间
    private Date createTime;
    // 博客id
    private Long blogId;
    // 父评论id
    private Long parentCommentId;
    // 父评论昵称
    private String parentNickName;
    // 回复评论
    private List<Comment> replyComments = new ArrayList<>();
    // 是否管理员评论
    private boolean adminComment;
    // 所属博客
    private DetailedBlog blog;

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ",email='" + email + '\'' +
                ",nickName='" + nickName + '\'' +
                ",content='" + content + '\'' +
                ",avatar='" + avatar + '\'' +
                ",createTime='" + createTime + '\'' +
                ",blogId=" + blogId +
                ",parentCommentId=" + parentCommentId +
                ",parentNickName='" + parentNickName + '\'' +
                ",replyComments='" + replyComments + '\'' +
                ",adminComment=" + adminComment +
                ",blog='" + blog + '\'' +
                '}';
    }

}
