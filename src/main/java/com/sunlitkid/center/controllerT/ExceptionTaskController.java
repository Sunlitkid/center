package com.sunlitkid.center.controllerT;

import com.alibaba.fastjson.JSONObject;
import com.sunlitkid.center.operator.timer.SecurityTimerTask;
import com.sunlitkid.center.common.dateFactory.JsonFactory;
import com.sunlitkid.center.operator.timer.CenterTimer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by sunlitkid on 2017/8/2.
 */
@RestController
@RequestMapping("/exceptionTask")
public class ExceptionTaskController {
    @PostMapping("/start")
    JSONObject start(String name) {
        SecurityTimerTask task =  new SecurityTimerTask(name) {
            @Override
            public void task() {
                System.out.println(1);
                throw  new RuntimeException("");
            }
        };
        CenterTimer.startTask(name,task,new Date(),10000);
        return JsonFactory.successJson("定时器:"+name+"设置成功");
    }
}
