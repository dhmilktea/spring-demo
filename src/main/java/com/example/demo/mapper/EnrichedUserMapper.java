package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface EnrichedUserMapper {

    void addByMap(Map<String, Object> enrichedUsers);

    void addAllByMap(List<Map<String, Object>> enrichedUsers);
}