package com.example.xyblog.Controller.admin;

import com.example.xyblog.Bean.Blog;
import com.example.xyblog.Bean.Type;
import com.example.xyblog.Queryvo.BlogQuery;
import com.example.xyblog.Queryvo.SearchBlog;
import com.example.xyblog.Queryvo.ShowBlog;
import com.example.xyblog.Service.BlogService;
import com.example.xyblog.Service.CommentService;
import com.example.xyblog.Service.TypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class BlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private CommentService commentService;

    @GetMapping("/blogs")
    public String blogs(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        PageHelper.startPage(pageNum, 10);
        List<BlogQuery> blogQueries = blogService.listBlogs();
        if (blogQueries != null) {
            PageInfo<BlogQuery> pageInfo = new PageInfo<>(blogQueries);
            model.addAttribute("pageInfo", pageInfo);
        }
        List<Type> types = typeService.listTypes();
        model.addAttribute("types", types);
        return "admin/blogs";
    }

    //跳转到新增页面
    @GetMapping("/blogs/input")
    public String input(Model model) {
        model.addAttribute("types", typeService.listTypes());
        model.addAttribute("blog", new Blog());
        return "admin/blogs-input";
    }

    // 新增页面
    @PostMapping("/blogs")
    public String saveBlog(Blog blog, RedirectAttributes attributes) {
        attributes.addFlashAttribute("message", blogService.saveBlog(blog) == 0 ? "添加失败" : "添加成功");
        return "redirect:/admin/blogs";
    }

    // 博客编辑页面
    @GetMapping("/blogs/{id}/input")
    public String editBlog(@PathVariable Long id, Model model) {
        model.addAttribute("blog", blogService.getBlogById(id));
        model.addAttribute("types", typeService.listTypes());
        return "admin/blogs-input";
    }

    // 保存编辑
    @PostMapping("/blogs/{id}")
    public String updateBlog(@Valid ShowBlog blog, RedirectAttributes attributes) {
        attributes.addFlashAttribute("message", blogService.updateBlog(blog) == 0 ? "更改失败" : "更改成功");
        return "redirect:/admin/blogs";
    }

    // 删除博客
    @GetMapping("/blogs/{id}/delete")
    public String deleteBlog(@PathVariable Long id, RedirectAttributes attributes) {
        attributes.addFlashAttribute("message", blogService.deleteBlogById(id) == 0 ? "删除失败" : "删除成功");
        return "redirect:/admin/blogs";
    }

    // 搜索博客
    @PostMapping("blogs/search")
    public String searchBlog(@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum,
                             SearchBlog searchBlog, Model model) {
        PageHelper.startPage(pageNum, 10);
        PageInfo<SearchBlog> pageInfo = new PageInfo<>(blogService.searchBlogs(searchBlog));
        model.addAttribute("pageInfo", pageInfo);
        return "admin/blogs :: blogList";
    }


}
