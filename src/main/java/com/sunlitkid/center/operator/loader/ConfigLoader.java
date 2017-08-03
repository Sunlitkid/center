package com.sunlitkid.center.operator.loader;

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
        String driver = null;
        String url = null;
        String username = null;
        String password = null;
        String sql = null;
        try(InputStream resource =ConfigLoader.class.getResourceAsStream("/application.properties")){
            properties.load(resource);
            driver = properties.getProperty("db.mysql.driver");
            url = "jdbc:mysql://" + properties.getProperty("db.mysql.ip") + ":" + properties.getProperty("db.mysql.port") + "/" + properties.getProperty("db.mysql.name");
            username = properties.getProperty("db.mysql.username");
            password = properties.getProperty("db.mysql.password");
            sql = "select * from "+properties.getProperty("db.mysql.tableName");
        }catch (Exception e){
            e.printStackTrace();
        }
        Class.forName(driver);
        try(Connection conn = DriverManager.getConnection(url, username, password);PreparedStatement ps =conn.prepareStatement(sql);ResultSet rs = ps.executeQuery();){
            while (rs.next()) {
                config.put(rs.getString(1),rs.getString(2));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
