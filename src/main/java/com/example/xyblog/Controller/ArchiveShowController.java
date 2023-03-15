package com.example.xyblog.Controller;

import com.example.xyblog.Service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArchiveShowController {
    @Autowired
    private BlogService blogService;

    @GetMapping("archives")
    public String archives(Model model) {
        model.addAttribute("blogs", blogService.getArchiveBlogs());
        return "archives";
    }
}
