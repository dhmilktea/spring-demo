package com.example.demo.service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper mapper;

    public List<User> getAll() {
        return mapper.findAll();
    }

    public User getById(Long id) {
        return mapper.findById(id);
    }

    public int countUsers() {
        return mapper.countUsers();
    }

    public void createBulk(List<User> users) {
        mapper.addAll(users);
    }

    public void createBulkMap(List<Map<String, Object>> users) {
        mapper.addAllByMap(users);
    }
}