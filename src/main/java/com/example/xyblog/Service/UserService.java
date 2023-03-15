package com.example.xyblog.Service;

import com.example.xyblog.Bean.User;

public interface UserService {
    User checkUsernameAndPassword(String username, String password);
}
