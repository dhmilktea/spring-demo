package com.example.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BatchController {

    private final JobLauncher launcher;
    private final Job userUppercaseJob;

    @PostMapping("/batch/run")
    public String run() throws Exception {
        launcher.run(userUppercaseJob,
                new JobParametersBuilder().addLong("time", System.currentTimeMillis()).toJobParameters());
        return "Batch started";
    }
}