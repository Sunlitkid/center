package com.sunlitkid.center.controller;

import com.alibaba.fastjson.JSONObject;
import com.sunlitkid.center.common.dateFactory.JsonFactory;
import com.sunlitkid.center.operator.timer.CenterTimer;
import com.sunlitkid.center.operator.timer.OnceTimer;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by huaching on 2017/8/1.
 */
@RestController
@RequestMapping("/onceTask")
public class OnceTaskController {
    @PostMapping("/start")
    JSONObject start(String name) {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println(name);
            }
        };
        String taskName =CenterTimer.startTask(name,task,new Date(),10000);
        return JsonFactory .successJson("定时器:"+taskName+"设置成功");
    }
    @PostMapping("/stop")
    JSONObject stop( String name) {
        if(CenterTimer.stopTask(name)){
            return JsonFactory .successJson("定时器:"+name+"停止成功");
        }else{
            return JsonFactory .successJson("定时器:"+name+"不存在");
        }
    }
}
