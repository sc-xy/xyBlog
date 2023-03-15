package com.example.xyblog.Service.Impl;

import com.example.xyblog.Bean.User;
import com.example.xyblog.Mapper.UserMapper;
import com.example.xyblog.Service.UserService;
import com.example.xyblog.Utils.Md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User checkUsernameAndPassword(String username, String password) {
        return userMapper.checkUsernameAndPassword(username, Md5Utils.code(password));
    }
}
