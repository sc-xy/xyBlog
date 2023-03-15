package com.example.xyblog.Mapper;

import com.example.xyblog.Bean.FriendLink;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface FriendLinkMapper {
    // 查询所有友链
    List<FriendLink> getFriendLinks();
    // 根据博客地址查询友链是否重复
    FriendLink getFriendLinkByAddress(String linkAddress);
    // 保存友链
    int saveFriendLink(FriendLink friendLink);
    // id查询友链
    FriendLink getFriendLinkById(Long id);
    // 更新友链
    int updateFriendLink(FriendLink friendLink);
    // 删除友链
    void deleteFriendLink(Long id);
}
