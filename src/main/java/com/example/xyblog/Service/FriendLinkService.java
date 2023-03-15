package com.example.xyblog.Service;


import com.example.xyblog.Bean.FriendLink;

import java.util.List;

public interface FriendLinkService {
    List<FriendLink> getFriendLinks();

    FriendLink getFriendLinkByAddress(String linkAddress);


    int saveFriendLink(FriendLink friendLink);

    FriendLink getFriendLinkById(Long id);

    int updateFriendLink(FriendLink friendLink);

    void deleteFriendLink(Long id);
}
