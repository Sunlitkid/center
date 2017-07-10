package com.sunlitkid.center.config.api;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by huaching on 2017/7/7.
 */
@Configuration
@ConfigurationProperties(prefix = "weather")
public class WeatherAPIConfig {
    private String url;
    private String appkey;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAppkey() {
        return appkey;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey;
    }
}
