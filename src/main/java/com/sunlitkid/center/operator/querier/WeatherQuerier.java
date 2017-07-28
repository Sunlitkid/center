package com.sunlitkid.center.operator.querier;

import com.alibaba.fastjson.JSONObject;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.sunlitkid.center.common.template.JsonResultTemplate;
import com.sunlitkid.center.config.WeatherAPIConfig;
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
    public  JSONObject getWeather(String city) {
        try {
            HttpResponse<JsonNode> jsonResponse;
            String url = String.format("%s?city=%s&appkey=%s",config.getUrl(),city,config.getAppkey());
            jsonResponse = Unirest.get(url).asJson();
            JSONObject object = (JSONObject) JSONObject.parse(jsonResponse.getBody().toString());
            return  format(object);
        } catch (UnirestException e) {
            e.printStackTrace();
            return JsonResultTemplate.exceptionJson(e);
        }
    }

    private JSONObject format(JSONObject object){
        if("10000".equals(object.get("code"))){
            return  JsonResultTemplate.successJson(object.getJSONObject("result"));
        }
        String error= object.getString("msg");
        if(error==null){
            return  JsonResultTemplate.errorJson("未查询到数据");
        }else{
            return  JsonResultTemplate.errorJson(error);
        }
    }
}
