package com.sunlitkid.center.controller;

import com.sunlitkid.center.config.MySqlConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    MySqlConfig config;

    @GetMapping("/get")
    String hello() {
        System.out.println(config.getIp());
        return config.getIp();
    }
}