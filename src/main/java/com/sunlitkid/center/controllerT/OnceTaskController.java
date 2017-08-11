package com.sunlitkid.center.controllerT;

import com.alibaba.fastjson.JSONObject;
import com.sunlitkid.center.common.dateFactory.JsonFactory;
import com.sunlitkid.center.operator.timer.CenterTimer;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by sunlitkid on 2017/8/1.
 */
@RestController
@RequestMapping("/onceTask")
public class OnceTaskController {
    @PostMapping("/start")
    JSONObject start(String name) {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                try{
                    System.out.println(name);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        JSONObject json =CenterTimer.startTask(name,task,new Date(),10000);
        if(json==null){
            return  JsonFactory.successJson("任务启动失败");
        }else{
            return  JsonFactory.successJson(json);
        }
    }
}
