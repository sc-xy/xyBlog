package com.example.xyblog.Service.Impl;

import com.example.xyblog.Bean.Message;
import com.example.xyblog.Mapper.MessageMapper;
import com.example.xyblog.Service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageMapper messageMapper;
    private List<Message> tempReplys = new ArrayList<>();

    @Override
    public List<Message> listMessages() {
        //查询出父节点
        List<Message> messages = messageMapper.findByParentIdNull(Long.parseLong("-1"));
        for(Message message : messages){
            Long id = message.getId();
            String parentNickname1 = message.getNickName();
            List<Message> childMessages = messageMapper.findByParentIdNotNull(id);
            //查询出子留言
            combineChildren(childMessages, parentNickname1);
            message.setReplyMessages(tempReplys);
            tempReplys = new ArrayList<>();
        }
        return messages;
    }

    private void combineChildren(List<Message> childMessages, String parentNickname1) {
        //判断是否有一级子回复
        if(childMessages.size() > 0){
            //循环找出子留言的id
            for(Message childMessage : childMessages){
                String parentNickname = childMessage.getNickName();
                childMessage.setParentNickName(parentNickname1);
                tempReplys.add(childMessage);
                Long childId = childMessage.getId();
                //查询二级以及所有子集回复
                recursively(childId, parentNickname);
            }
        }
    }

    private void recursively(Long childId, String parentNickname1) {
        //根据子一级留言的id找到子二级留言
        List<Message> replayMessages = messageMapper.findByReplyId(childId);

        if(replayMessages.size() > 0){
            for(Message replayMessage : replayMessages){
                String parentNickname = replayMessage.getNickName();
                replayMessage.setParentNickName(parentNickname1);
                Long replayId = replayMessage.getId();
                tempReplys.add(replayMessage);
                //循环迭代找出子集回复
                recursively(replayId,parentNickname);
            }
        }
    }

    @Override
    public void saveMessage(Message message) {
        message.setCreateTime(new Date());
        messageMapper.saveMessage(message);
    }

    @Override
    public void deleteMessage(Long id) {
        messageMapper.deleteMessage(id);
    }
}
