package com.sunlitkid.center.controller;

import com.alibaba.fastjson.JSONObject;
import com.sunlitkid.center.common.dateFactory.JsonFactory;
import com.sunlitkid.center.operator.timer.CenterTimer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.TimerTask;

/**
 * Created by huaching on 2017/8/2.
 */
@RestController
@RequestMapping("/exceptionTask")
public class ExceptionTaskController {
    @PostMapping("/start")
    JSONObject start(String name) {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                try{
                    throw new  RuntimeException("123");
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        CenterTimer.startTask(name,task,new Date(),10000);
        return JsonFactory.successJson("定时器:"+name+"设置成功");
    }
    @PostMapping("/stop")
    JSONObject stop( String name) {
        CenterTimer.stopTask(name);
        return JsonFactory .successJson("定时器:"+name+"停止成功");
    }
}
