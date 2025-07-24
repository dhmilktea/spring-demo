package com.example.demo.controller;

import com.example.demo.MyProperties;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class UserController extends QuartzJobBean {

    private final UserService service;

    private final MyProperties myProperties;

    @GetMapping
    public List<User> list() {
        log.info(myProperties.getName());
        log.info(myProperties.getType());
        log.info(String.valueOf(service.countUsers()));
        return service.getAll();
    }

    @GetMapping("/{id}")
    public User one(@PathVariable Long id) {
        return service.getById(id);
    }

    @Scheduled(cron = "#{myProperties.cron}")
    @PostMapping
    public void postList() {
        log.info(myProperties.getName());
    }

    void a(){
        try{
            b();
        }catch (Exception e){
            log.error("a_c");
        } finally {
            log.info("a_f");
        }
    }

    void b() throws Exception{
        try {
            // insert  -> exception
            System.out.println();
            throw new Exception("ERROR!!!");
        } catch (Exception e){
            log.error("b_c");
            throw e;
        } finally {
            log.info("b_f");
        }
    }

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        log.info(myProperties.getType());
        a();
    }
}