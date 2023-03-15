package com.example.xyblog.Service.Impl;

import com.example.xyblog.Bean.Blog;
import com.example.xyblog.Mapper.BlogMapper;
import com.example.xyblog.NotFoundException;
import com.example.xyblog.Queryvo.*;
import com.example.xyblog.Service.BlogService;
import com.example.xyblog.Service.CommentService;
import com.example.xyblog.Utils.MarkDownUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogMapper blogMapper;
    @Autowired
    private CommentService commentService;

    //  查询所有博客
    @Override
    public List<BlogQuery> listBlogs() {
        return blogMapper.listBlogs();
    }

    //  保存新的博客
    @Override
    public int saveBlog(Blog blog) {
        blog.setUpdateTime(new Date());
        blog.setCommentCount(0);
        blog.setViews(0);
        return blogMapper.saveBlog(blog);
    }

    @Override
    public ShowBlog getBlogById(Long id) {
        return blogMapper.getBlogById(id);
    }

    @Override
    public int updateBlog(ShowBlog showBlog) {
        showBlog.setUpdateTime(new Date());
        return blogMapper.updateBlog(showBlog);
    }

    @Override
    public int deleteBlogById(Long id) {
        commentService.deleteCommentByBlogId(id);
        return blogMapper.deleteBlogById(id);
    }

    @Override
    public List<SearchBlog> searchBlogs(SearchBlog searchBlog) {
        return blogMapper.searchBlogs(searchBlog);
    }

    @Override
    public List<FirstPageBlog> getFirstPageBlogs() {
        return blogMapper.getFirstPageBlogs();
    }

    @Override
    public List<RecommendBlog> recommendedBlogs() {
        return blogMapper.getRecommendBlogs();
    }

    //    前端搜索博客
    @Override
    public List<FirstPageBlog> getSearchBlogs(String query) {
        return blogMapper.getSearchBlog(query);
    }

    //    根据id获取博客详情页面
    @Override
    public DetailedBlog getDetailedBlogById(Long id) {
        DetailedBlog detailedBlog = blogMapper.getDetailedBlogById(id);
        if (detailedBlog == null) {
            throw new NotFoundException("该博客不存在");
        }
        detailedBlog.setContent(MarkDownUtils.markdownToHtmlExtension(detailedBlog.getContent()));
        // 更新浏览数和评论数
        blogMapper.updateViews(id);
        blogMapper.getCommentCountById(id);
        return detailedBlog;
    }

    @Override
    public Integer getBlogTotal() {
        return blogMapper.getBlogTotal();
    }

    @Override
    public Integer getBlogViewTotal() {
        return blogMapper.getBlogTotal();
    }

    @Override
    public Integer getBlogCommentTotal() {
        return blogMapper.getCommentTotal();
    }

    @Override
    public Integer getMessageTotal() {
        return blogMapper.getMessageTotal();
    }

    @Override
    public List<FirstPageBlog> getBlogsByTypeId(Long id) {
        return blogMapper.getBlogsByTypeId(id);
    }

    @Override
    public List<ArchiveBlog> getArchiveBlogs() {
        return blogMapper.getArchiveBlogs();
    }

    public static void main(String[] args) {
        System.out.println(new BlogServiceImpl().getFirstPageBlogs());
    }
}
