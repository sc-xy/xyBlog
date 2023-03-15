package com.example.xyblog.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/about")
public class AboutShowController {
    @GetMapping
    public String aboutShow(){
        return "about";
    }
}
