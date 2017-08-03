package com.sunlitkid.center.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by sunke on 2017/7/7.
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("/success")
    @ResponseBody
    String hello() {
        return "你好";
    }
    public static void main(String[] args) {
        ConcurrentHashMap<String,Date> map = new ConcurrentHashMap<String, Date>();
        map.remove(null);
    }
}
