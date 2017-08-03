package com.sunlitkid.center.operator.timer;

import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by sunke on 2017/8/1.
 */
public abstract class  OnceTimer {
    public OnceTimer(Date date){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                task();
            }
        }, date);
    }
    abstract public  void task();
}
