package com.example.demo.mapper;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
    List<User> findAll();

    List<Map<String, Object>> findAllMap();

    User findById(@Param("id") Long id);

    void updateName(User user);

    int countUsers();

    void addAll(List<User> users);

    void addAllByMap(List<Map<String, Object>> users);
}