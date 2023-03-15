package com.example.xyblog.Service;

import com.example.xyblog.Bean.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> listCommentByBlogId(Long id);

    void saveComment(Comment comment);

    void deleteComment(Comment comment, Long id);

    void deleteCommentByBlogId(Long blogId);
}
