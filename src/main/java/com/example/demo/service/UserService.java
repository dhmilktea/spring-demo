package com.example.demo.service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
}