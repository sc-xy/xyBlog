package com.example.xyblog.Controller;

import com.example.xyblog.Queryvo.FirstPageBlog;
import com.example.xyblog.Queryvo.RecommendBlog;
import com.example.xyblog.Service.BlogService;
import com.example.xyblog.Service.CommentService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.github.pagehelper.PageHelper;

import java.util.List;

/**
 * author: 某洋
 * description:
 */
@Controller
public class IndexShowController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private CommentService commentService;

    // 首页展示
    @GetMapping("/")
    public String index(@RequestParam(name = "pageNum", defaultValue = "1") Integer pageNum, Model model) {
        PageHelper.startPage(pageNum, 10);
        // 首页博客展示
        List<FirstPageBlog> firstPageBlogs = blogService.getFirstPageBlogs();
        // 推荐博客
        List<RecommendBlog> recommendBlogs = blogService.recommendedBlogs();
        // 博客按10个一页分页
        PageInfo<FirstPageBlog> pageInfo = new PageInfo<>(firstPageBlogs);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("recommendBlogs", recommendBlogs);
        return "index";
    }

    // 搜索博客
    @PostMapping("/search")
    public String search(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                         @RequestParam(value = "query") String query,
                         Model model) {
        PageHelper.startPage(pageNum, 1000);
        List<FirstPageBlog> blogs = blogService.getSearchBlogs(query);
        PageInfo pageInfo = new PageInfo<>(blogs);
        model.addAttribute("pageInfo", pageInfo);
        return "search";
    }

    // 跳转到博客详情页面
    @GetMapping("/blog/{id}")
    public String blog(@PathVariable Long id, Model model) {
        model.addAttribute("blog", blogService.getDetailedBlogById(id));
        model.addAttribute("comments", commentService.listCommentByBlogId(id));
        return "blog";
    }

    // 底部信息查询
    @GetMapping("/footer/blogmessage")
    public String blogMessage(Model model) {
        int blogTotal = blogService.getBlogTotal();
        model.addAttribute("blogTotal", blogTotal);
        int blogViewTotal = blogService.getBlogViewTotal();
        model.addAttribute("blogViewTotal", blogViewTotal);
        int blogCommentTotal = blogService.getBlogCommentTotal();
        model.addAttribute("blogCommentTotal", blogCommentTotal);
        int blogMessageTotal = blogService.getMessageTotal();
        model.addAttribute("blogMessageTotal", blogMessageTotal);
        return "index :: blogMessage";
    }
}
