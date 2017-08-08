package com.sunlitkid.center.controller;

import com.alibaba.fastjson.JSONObject;
import com.sunlitkid.center.common.dateFactory.JsonFactory;
import com.sunlitkid.center.operator.timer.CenterTimer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sunke on 2017/8/8.
 */
@RestController
@RequestMapping("/task")
public class TaskController {
    /**
     * 获取所有的task
     * @return
     */
    @PostMapping("/task")
    JSONObject map() {
        JSONObject json  =new JSONObject();
        json .put("task", CenterTimer.getTasks());
        return JsonFactory.successJson(json);
    }
    /**
     * 通过uuid关闭task
     * @param uuid
     * @return
     */
    @PostMapping("/stop")
    JSONObject stop( String uuid) {
        if(CenterTimer.stopTask(uuid)){
            return JsonFactory .successJson("任务:"+uuid+"停止成功");
        }else{
            return JsonFactory .successJson("任务:"+uuid+"不存在");
        }
    }
}
