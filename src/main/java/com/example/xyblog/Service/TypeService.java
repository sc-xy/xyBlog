package com.example.xyblog.Service;

import com.example.xyblog.Bean.Type;

import java.util.List;

public interface TypeService {
    List<Type> listTypes();

    Type getType(Long typeId);

    List<Type> getAlltype();

    int saveType(Type type);

    Type getTypeByName(String name);

    int updateType(Type type);

    int deleteById(Long id);

    List<Type> listTypesAndBlogs();
}
