package com.example.xyblog.Mapper;

import com.example.xyblog.Bean.Blog;
import com.example.xyblog.Queryvo.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BlogMapper {
    // 查询所有博客
    List<BlogQuery> listBlogs();
    // 保存博客
    int saveBlog(Blog blog);
    // 通过id查询博客
    ShowBlog getBlogById(Long id);
    // 修改博客
    int updateBlog(ShowBlog showBlog);
    // 删除博客
    int deleteBlogById(Long id);
    // 搜索博客
    List<SearchBlog> searchBlogs(SearchBlog searchBlog);
    // 前端博客首页查询
    List<FirstPageBlog> getFirstPageBlogs();
    // 推荐博客查询
    List<RecommendBlog> getRecommendBlogs();
    // 搜索博客
    List<FirstPageBlog> getSearchBlog(String query);
    // 博客详情
    DetailedBlog getDetailedBlogById(Long Id);
    // 文章访问自增
    void updateViews(Long id);
    // 更新博客评论数
    void getCommentCountById(Long id);
    // 博客总数 访问总数 评论总数 留言总数
    Integer getBlogTotal();
    Integer getViewsTotal();
    Integer getCommentTotal();
    Integer getMessageTotal();
    // 根据类别Id获取博客
    List<FirstPageBlog> getBlogsByTypeId(Long id);
    // 时间轴获取博客
    List<ArchiveBlog> getArchiveBlogs();


}
