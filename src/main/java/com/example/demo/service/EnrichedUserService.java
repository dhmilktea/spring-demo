package com.example.demo.service;

import com.example.demo.mapper.EnrichedUserMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
public class EnrichedUserService {

    private final UserMapper mapper;
    private final EnrichedUserMapper enrichedUserMapper;

    @Transactional
    public void enrichUser() throws RuntimeException {
        List<Map<String, Object>> users = mapper.findAllMap();
//        List<Map<String, Object>> enrichedUsers = new ArrayList<>();
        int count=0;
        for (Map<String, Object> user : users) {
            Map<String, Object> copiedUser = new HashMap<>(user);
            copiedUser.put("description", "test");
            System.out.println(copiedUser);
            enrichedUserMapper.addByMap(copiedUser);
            count++;
            if (count==2) {
                throw new RuntimeException();
            }
//            enrichedUsers.add(copiedUser);
        }
//        System.out.println(enrichedUsers);
    }
}