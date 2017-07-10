package com.sunlitkid.center.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by sunlitkid on 2017/7/5.
 */
//将配置文件加载进依赖
//这两个注解都可以
//@Component
@Configuration

//必须要有getter和setter
@ConfigurationProperties(prefix = "db.mysql")
public class MySqlConfig {
    private String ip;
    private int port;
    private String username;
    private String password;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
