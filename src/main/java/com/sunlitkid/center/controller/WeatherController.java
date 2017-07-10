package com.sunlitkid.center.controller;

import com.alibaba.fastjson.JSONObject;
import com.sunlitkid.center.common.template.JsonResultTemplate;
import com.sunlitkid.center.operator.WeatherQuerier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sunke on 2017/7/7.
 */
@RestController
@RequestMapping("/weather")
public class WeatherController {
    @Autowired
    WeatherQuerier weatherQuerier;
    @GetMapping("/{city}")
    JSONObject get(@PathVariable("city") String city) {
        return  JsonResultTemplate.successJson(weatherQuerier.getWeather(city));
    }
}
