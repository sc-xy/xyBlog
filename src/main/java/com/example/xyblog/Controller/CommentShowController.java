package com.example.xyblog.Controller;


import com.example.xyblog.Bean.Comment;
import com.example.xyblog.Bean.User;
import com.example.xyblog.Queryvo.DetailedBlog;
import com.example.xyblog.Service.BlogService;
import com.example.xyblog.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import static com.example.xyblog.Utils.ApiUtils.jsonData;

@Controller
public class CommentShowController {
    @Autowired
    private CommentService commentService;

    @Autowired
    private BlogService blogService;


    // 查询评论列表
    @GetMapping("comments/{blogId}")
    public String comments(@PathVariable Long blogId, Model model) {
        List<Comment> comments = commentService.listCommentByBlogId(blogId);
        model.addAttribute("comments", comments);
        return "blog :: commentList";
    }

    // 新增评论
    @PostMapping("/comments")
    public String addComment(Comment comment, HttpSession session, RedirectAttributes attributes) {
        Long blogId = comment.getBlogId();
        User user = (User) session.getAttribute("user");
        boolean flag = true;
        if (user != null) {
            // 如果是管理员
            comment.setAvatar(user.getAvatar());
            comment.setAdminComment(true);
        } else {
            try {
                // 如果不是管理
                comment.setEmail(comment.getNickName() + "@qq.com");
                comment.setAvatar((String) jsonData(comment.getNickName()).get("avatar"));
                comment.setNickName((String) jsonData(comment.getNickName()).get("name"));
            } catch (IOException e) {
                flag = false;
            }
        }
        System.out.println(comment.getParentCommentId());
        if (flag) {
            commentService.saveComment(comment);
        }
        List<Comment> comments = commentService.listCommentByBlogId(blogId);
        attributes.addFlashAttribute("comments", comments);
        return "redirect:/blog/"+comment.getBlogId().toString();
    }

    // 删除评论
    @GetMapping("/comment/{blogId}/{id}/delete")
    public String deleteById(@PathVariable Long blogId, @PathVariable Long id, Comment comment, RedirectAttributes attributes, Model model){
        commentService.deleteComment(comment,id);
        DetailedBlog detailedBlog = blogService.getDetailedBlogById(blogId);
        List<Comment> comments = commentService.listCommentByBlogId(blogId);
        model.addAttribute("blog", detailedBlog);
        model.addAttribute("comments", comments);
        return "blog";
    }
}
