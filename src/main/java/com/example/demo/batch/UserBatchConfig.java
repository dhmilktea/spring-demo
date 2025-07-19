package com.example.demo.batch;

import com.example.demo.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
@RequiredArgsConstructor
public class UserBatchConfig {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    private static final int CHUNK_SIZE = 10;

    @Bean
    public Step userUppercaseStep(ItemReader<User> reader,
                                  ItemProcessor<User, User> processor,
                                  ItemWriter<User> writer,
                                  ChunkLoggingListener chunkLoggingListener) {
        return stepBuilderFactory.get("userUppercaseStep")
                .<User, User>chunk(CHUNK_SIZE)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .listener(chunkLoggingListener)
                .build();
    }

    @Bean
    public Job userUppercaseJob(Step userUppercaseStep) {
        return jobBuilderFactory.get("userUppercaseJob")
                .incrementer(new RunIdIncrementer())
                .flow(userUppercaseStep)
                .end()
                .build();
    }
}