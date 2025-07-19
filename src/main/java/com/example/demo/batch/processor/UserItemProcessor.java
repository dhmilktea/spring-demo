package com.example.demo.batch.processor;

import com.example.demo.model.User;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class UserItemProcessor implements ItemProcessor<User, User> {
    @Override
    public User process(User user) {
        user.setName(user.getName().toUpperCase());
        return user;
    }
}