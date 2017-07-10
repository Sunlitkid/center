package com.sunlitkid.center.controller;

import com.alibaba.fastjson.JSONObject;
import com.sunlitkid.center.common.template.JsonResultTemplate;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sunke on 2017/7/7.
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("/success")
    JSONObject hello() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","sunke");
        return JsonResultTemplate.permissionDeniedJson();
    }
}
