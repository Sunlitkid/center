package com.sunlitkid.center.controller;

import com.alibaba.fastjson.JSONObject;
import com.sunlitkid.center.common.dateFactory.JsonFactory;
import com.sunlitkid.center.config.HomeStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sunke on 2017/8/8.
 */
@RestController
@RequestMapping("/home")
public class HomeController {
    @GetMapping("/temperature")
    JSONObject temperature() {
        return  JsonFactory.successJson(HomeStatus.getTemperature());
    }
    @GetMapping("/humidity")
    JSONObject humidity() {
        return  JsonFactory.successJson(HomeStatus.getHumidity());
    }
    @GetMapping("/luminance")
    JSONObject luminance() {
        return  JsonFactory.successJson(HomeStatus.getLuminance());
    }
}
