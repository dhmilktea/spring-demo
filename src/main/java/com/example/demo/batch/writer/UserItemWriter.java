package com.example.demo.batch.writer;

import com.example.demo.model.User;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.batch.MyBatisBatchItemWriter;
import org.mybatis.spring.batch.builder.MyBatisBatchItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserItemWriter {

//    @Bean
//    public ItemWriter<User> writer(SqlSessionFactory sqlSessionFactory) {
//        MyBatisBatchItemWriter<User> delegate = new MyBatisBatchItemWriterBuilder<User>()
//                .sqlSessionFactory(sqlSessionFactory)
//                .statementId("com.example.demo.mapper.UserMapper.updateName")
//                .build();
//
//        return (List<? extends User> items) -> {
//            if (!items.isEmpty()) {
//                User first = items.get(0);
//                User last  = items.get(items.size() - 1);
//                log.info("💾  Writing chunk ({} rows)  id {} .. {}", items.size(), first.getId(), last.getId());
//            }
//            delegate.write(items);
//        };
//    }

    @Bean
    public MyBatisBatchItemWriter<User> writer(SqlSessionFactory sqlSessionFactory) {
        return new MyBatisBatchItemWriterBuilder<User>()
                .sqlSessionFactory(sqlSessionFactory)
                .statementId("com.example.demo.mapper.UserMapper.updateName")
                .build();
    }
}