package com.example.xyblog.Mapper;

import com.example.xyblog.Bean.Type;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TypeMapper {
    List<Type> listTypes();

    Type getType(Long typeId);

    int saveType(Type type);

    Type getTypeByName(String name);

    int updateType(Type type);

    int deleteById(Long id);

    List<Type> listTypesAndBlogs();
}
