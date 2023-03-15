package com.example.xyblog.Service;

import java.util.List;
import com.example.xyblog.Queryvo.*;
import com.example.xyblog.Bean.Blog;

public interface BlogService {
    List<BlogQuery> listBlogs();

    int saveBlog(Blog blog);

    ShowBlog getBlogById(Long id);

    int updateBlog(ShowBlog showBlog);

    int deleteBlogById(Long id);

    List<SearchBlog> searchBlogs(SearchBlog searchBlog);

    List<FirstPageBlog> getFirstPageBlogs();

    List<RecommendBlog> recommendedBlogs();

    List<FirstPageBlog> getSearchBlogs(String query);

    DetailedBlog getDetailedBlogById(Long id);

    Integer getBlogTotal();

    Integer getBlogViewTotal();

    Integer getBlogCommentTotal();

    Integer getMessageTotal();

    List<FirstPageBlog> getBlogsByTypeId(Long id);

    List<ArchiveBlog> getArchiveBlogs();

}
