package com.sunlitkid.center.common.util;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;


/**
 * Created by sunke on 2017/7/27.
 */
@Service
public class ConfigLoader {
    static private JSONObject config ;
    public static JSONObject getConfig() throws Exception {
        if(config==null){
            load();
            return  config;
        }else{
            return  config;
        }
    }
    private static void  load() throws Exception {
        config = new JSONObject();
        Properties properties = new Properties();
        InputStream resource =ConfigLoader.class.getResourceAsStream("/application.properties");
        properties.load(resource);
        Class.forName(properties.getProperty("db.mysql.driver"));
        //  获得链接
        String url = "jdbc:mysql://" + properties.getProperty("db.mysql.ip") + ":" + properties.getProperty("db.mysql.port") + "/" + properties.getProperty("db.mysql.name");
        String username = properties.getProperty("db.mysql.username");
        String password = properties.getProperty("db.mysql.password");
        Connection conn = DriverManager.getConnection(url, username, password);
        String sql = "select * from "+properties.getProperty("db.mysql.tableName");
        PreparedStatement ps;
        // 存储过程通道
        ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            config.put(rs.getString(1),rs.getString(2));
        }
        rs.close();
        ps.close();
        conn.close();
        resource.close();
    }
}
