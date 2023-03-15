package com.example.xyblog.Mapper;

import com.example.xyblog.Bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {
    User checkUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
