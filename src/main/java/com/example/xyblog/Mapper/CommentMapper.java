package com.example.xyblog.Mapper;

import com.example.xyblog.Bean.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CommentMapper {
    //创建时间倒序
    List<Comment> findByBlogIdParentIdNull(@Param("blogId")Long blogId, @Param("parentId") Long parentId);
    //查询一级回复
    List<Comment> findByBlogIdParentIdNotNull(@Param("blogId") Long blogId, @Param("id") Long id);
    //查询二级回复
    List<Comment> findByBlogIdAndReplyId(@Param("blogId") Long blogId,@Param("childId") Long childId);
    // 保存评论
    void saveComment(Comment comment);
    // 删除评论
    void deleteComment(Long id);
    // 删除博客时删除评论
    void deleteCommentByBlogId(Long blogId);
}
