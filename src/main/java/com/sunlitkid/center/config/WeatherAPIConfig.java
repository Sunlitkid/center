package com.sunlitkid.center.config;

import com.alibaba.fastjson.JSONObject;
import com.sunlitkid.center.operator.loader.ConfigLoader;
import org.springframework.stereotype.Service;
/**
 * Created by sunlitkid on 2017/7/7.
 */
@Service
public class WeatherAPIConfig {
    private static  String url;
    private static  String appkey;
    static {
        try {
            JSONObject config =  ConfigLoader.getConfig();
            url = config.getString("weather.url");
            appkey = config.getString("weather.appkey");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String getUrl() {
        return url;
    }
    public String getAppkey() {
        return appkey;
    }
}
