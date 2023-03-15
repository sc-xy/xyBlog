package com.example.xyblog.Controller;

import com.example.xyblog.Bean.Message;
import com.example.xyblog.Bean.User;
import com.example.xyblog.Service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import static com.example.xyblog.Utils.ApiUtils.jsonData;

@Controller
public class MessageController {
    @Autowired
    private MessageService messageService;

    @GetMapping("/message")
    public String message() {
        return "message";
    }

    @GetMapping("/messagecomment")
    public String messages(Model model) {
        List<Message> messages = messageService.listMessages();
        model.addAttribute("messages", messages);
        return "message :: messageList";
    }

    @PostMapping("/message")
    public String post(Message message, HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        boolean flag = true;
        //设置头像
        if (user != null) {
            message.setAvatar(user.getAvatar());
            message.setAdminMessage(true);
        } else {
            try {
                System.out.println(message.getNickName());
                message.setEmail(message.getNickName() + "@qq.com");
                message.setAvatar((String) jsonData(message.getNickName()).get("avatar"));
                message.setNickName((String) jsonData(message.getNickName()).get("name"));
            } catch (IOException e) {
                flag = false;
            }
        }
        if(flag){
            messageService.saveMessage(message);
        }
        List<Message> messages = messageService.listMessages();
        model.addAttribute("messages", messages);
        return "message";
    }

    @GetMapping("/messages/{id}/delete")
    public String deleteMessage(@PathVariable Long id, Model model){
        messageService.deleteMessage(id);
        List<Message> messages = messageService.listMessages();
        model.addAttribute("messages", messages);
        return "redirect:/message";
    }


}
