package com.sunlitkid.center.operator;

import com.alibaba.fastjson.JSONObject;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.sunlitkid.center.common.template.JsonResultTemplate;
import com.sunlitkid.center.config.api.WeatherAPIConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sunke on 2017/7/7.
 * 天气查询器
 */

@Service
public class WeatherQuerier {
    @Autowired
    WeatherAPIConfig config;
    public  JSONObject getWeather(String city){
        try {
            HttpResponse<JsonNode> jsonResponse;
            String url = String.format("%s?city=%s&appkey=%s",config.getUrl(),city,config.getAppkey());
            jsonResponse = Unirest.get(url).asJson();
            JSONObject object = (JSONObject) JSONObject.parse(jsonResponse.getBody().toString());
            return  object;
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResultTemplate.exceptionJson(e);
        }
    }
}
