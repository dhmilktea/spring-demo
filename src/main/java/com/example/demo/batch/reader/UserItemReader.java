package com.example.demo.batch.reader;

import com.example.demo.model.User;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.batch.MyBatisCursorItemReader;
import org.mybatis.spring.batch.builder.MyBatisCursorItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserItemReader {

    @Bean
    public MyBatisCursorItemReader<User> reader(SqlSessionFactory sqlSessionFactory) {
        return new MyBatisCursorItemReaderBuilder<User>()
                .sqlSessionFactory(sqlSessionFactory)
                .queryId("com.example.demo.mapper.UserMapper.findAll")
                .build();
    }
}
