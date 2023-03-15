package com.example.xyblog.Controller;

import com.example.xyblog.Service.FriendLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FriendLinkShowController {
    @Autowired
    private FriendLinkService friendLinkService;

    @GetMapping("/friends")
    public String friendLinkShow(Model model){
        model.addAttribute("friendlinks", friendLinkService.getFriendLinks());
        return "friends";
    }
}
