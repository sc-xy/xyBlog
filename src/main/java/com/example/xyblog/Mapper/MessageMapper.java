package com.example.xyblog.Mapper;

import com.example.xyblog.Bean.Message;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MessageMapper {
    // 保存留言
    int saveMessage(Message message);
    //查询父级评论
    List<Message> findByParentIdNull(@Param("ParentId") Long ParentId);
    //查询一级回复
    List<Message> findByParentIdNotNull(@Param("id") Long id);
    //查询二级以及所有子集回复
    List<Message> findByReplyId(@Param("childId") Long childId);
    //删除评论
    void deleteMessage(Long id);
}
