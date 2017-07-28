package com.sunlitkid.center.controller;

import com.alibaba.fastjson.JSONObject;
import com.sunlitkid.center.common.util.ConfigLoader;
import com.sunlitkid.center.operator.querier.WeatherQuerier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by sunke on 2017/7/7.
 */
@RestController
@RequestMapping("/weather")
public class WeatherController {
    @Autowired
    WeatherQuerier weatherQuerier;
    @Autowired
    ConfigLoader loader;
    @GetMapping("/{city}")
    JSONObject get(@PathVariable("city") String city) {
        try {
            loader.getConfig();
        } catch (Exception e) {
            e.printStackTrace();
        }
       // System.out.println(config.getName());

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE,-30);
        System.out.println(calendar.getTime());
        return weatherQuerier.getWeather(city);
    }
}
