package com.example.xyblog.Service.Impl;

import com.example.xyblog.Bean.Comment;
import com.example.xyblog.Mapper.BlogMapper;
import com.example.xyblog.Mapper.CommentMapper;
import com.example.xyblog.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
@Transactional
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private BlogMapper blogMapper;

    List<Comment> tempReplys = new ArrayList<>();

    @Override
    public List<Comment> listCommentByBlogId(Long blogId) {
        //查询出父节点
        List<Comment> comments = commentMapper.findByBlogIdParentIdNull(blogId, Long.parseLong("-1"));
        for(Comment comment : comments){
            Long id = comment.getId();
            String parentNickname1 = comment.getNickName();
            List<Comment> childComments = commentMapper.findByBlogIdParentIdNotNull(blogId,id);
//            查询出子评论
            combineChildren(blogId, childComments, parentNickname1);
            comment.setReplyComments(tempReplys);
            tempReplys = new ArrayList<>();
        }
        return comments;
    }




    private void combineChildren(Long blogId, List<Comment> childComments, String parentNickname1) {
//        判断是否有一级子评论
        if(childComments.size() > 0){
//                循环找出子评论的id
            for(Comment childComment : childComments){
                String parentNickname = childComment.getNickName();
                childComment.setParentNickName(parentNickname1);
                tempReplys.add(childComment);
                Long childId = childComment.getId();
//                    查询出子二级评论
                recursively(blogId, childId, parentNickname);
            }
        }
    }

    private void recursively(Long blogId, Long childId, String parentNickname1) {
//        根据子一级评论的id找到子二级评论
        List<Comment> replayComments = commentMapper.findByBlogIdAndReplyId(blogId, childId);

        if (replayComments.size() > 0) {
            for (Comment replayComment : replayComments) {
                String parentNickname = replayComment.getNickName();
                replayComment.setParentNickName(parentNickname1);
                Long replayId = replayComment.getId();
                tempReplys.add(replayComment);
                recursively(blogId, replayId, parentNickname);
            }
        }//    新增评论
    }


    @Override
    public void saveComment(Comment comment) {
        comment.setCreateTime(new Date());
        commentMapper.saveComment(comment);
        // 更新对应博客评论数
        blogMapper.getCommentCountById(comment.getBlogId());
    }

    @Override
    public void deleteComment(Comment comment, Long id) {
        commentMapper.deleteComment(id);
        blogMapper.getCommentCountById(comment.getBlogId());
    }
    @Override
    public void deleteCommentByBlogId(Long blogId){
        commentMapper.deleteCommentByBlogId(blogId);
    }
}
