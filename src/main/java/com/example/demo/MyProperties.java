package com.example.demo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Setter
@Configuration
@Getter
@ConfigurationProperties(prefix = "myapp.service")
public class MyProperties {

    private String name;
    private String type;
    private String cron;

}