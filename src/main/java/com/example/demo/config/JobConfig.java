package com.example.demo.config;

import com.example.demo.controller.UserController;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

import static org.quartz.JobBuilder.newJob;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class JobConfig {

    private final Scheduler scheduler; // 쿼츠 스케줄 객체

    @PostConstruct
    public void run() {
        JobDetail detail = runJobDetail(UserController.class, new HashMap<>());

        try {
            // 크론형식 지정 후 스케줄 시작
            scheduler.scheduleJob(detail, runJobTrigger("0/10 * * * * ?"));
        } catch (SchedulerException e) {
            log.error(e.getMessage());
        }

    }

    public Trigger runJobTrigger(String scheduleExp) {
        // 크론 스케줄 사용
        return TriggerBuilder.newTrigger()
                .withSchedule(CronScheduleBuilder.cronSchedule(scheduleExp)).build();
    }

    public JobDetail runJobDetail(Class job, Map params) {
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.putAll(params);
        // 스케줄 생성
        return newJob(job).usingJobData(jobDataMap).build();
    }

}