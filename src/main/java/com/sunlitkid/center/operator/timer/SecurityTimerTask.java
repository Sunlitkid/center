package com.sunlitkid.center.operator.timer;

import com.sunlitkid.center.common.util.DateUtil;

import java.util.Date;
import java.util.TimerTask;

/**
 * Created by sunke on 2017/8/8.
 */
public  abstract class SecurityTimerTask extends  TimerTask{
    private String name;
    public  SecurityTimerTask(String name){
        this.name = name;
    }
    @Override
    public void run() {
        try{
            task();
        }catch (Exception e){
            //失败的执行放入日志
            e.printStackTrace();
            System.out.println(name);
            System.out.println(DateUtil.format(new Date()));
        }
    }
    abstract public void task();
}