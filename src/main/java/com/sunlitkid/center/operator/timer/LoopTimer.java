package com.sunlitkid.center.operator.timer;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * Created by sunke on 2017/8/1.
 */
public abstract  class LoopTimer {
    public LoopTimer(Date date , long period){
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Calendar calendar = Calendar.getInstance();
                System.out.println(calendar.getTime());
            }
        },date,1000);
        timer.cancel();
    }
    abstract void task();
}
