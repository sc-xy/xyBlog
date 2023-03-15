package com.example.xyblog.Service;

import com.example.xyblog.Bean.Message;

import java.util.List;

public interface MessageService {
    List<Message> listMessages();

    void saveMessage(Message message);

    void deleteMessage(Long id);
}
