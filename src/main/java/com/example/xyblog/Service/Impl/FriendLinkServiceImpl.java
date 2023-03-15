package com.example.xyblog.Service.Impl;

import com.example.xyblog.Bean.FriendLink;
import com.example.xyblog.Mapper.FriendLinkMapper;
import com.example.xyblog.Service.FriendLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FriendLinkServiceImpl implements FriendLinkService {
    @Autowired
    private FriendLinkMapper friendLinkMapper;
    @Override
    public List<FriendLink> getFriendLinks() {
        return friendLinkMapper.getFriendLinks();
    }

    @Override
    public FriendLink getFriendLinkByAddress(String linkAddress) {
        return friendLinkMapper.getFriendLinkByAddress(linkAddress);
    }

    @Override
    public int saveFriendLink(FriendLink friendLink) {
        return friendLinkMapper.saveFriendLink(friendLink);
    }

    @Override
    public FriendLink getFriendLinkById(Long id) {
        return friendLinkMapper.getFriendLinkById(id);
    }

    @Override
    public int updateFriendLink(FriendLink friendLink) {
        return friendLinkMapper.updateFriendLink(friendLink);
    }

    @Override
    public void deleteFriendLink(Long id) {
        friendLinkMapper.deleteFriendLink(id);
    }
}
