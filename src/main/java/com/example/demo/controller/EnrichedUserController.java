package com.example.demo.controller;

import com.example.demo.MyProperties;
import com.example.demo.model.User;
import com.example.demo.service.EnrichedUserService;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/enriched-users")
@RequiredArgsConstructor
@Slf4j
public class EnrichedUserController {

    private final EnrichedUserService service;

    @PostMapping
    public void postList() throws Exception {
        service.enrichUser();
    }
}