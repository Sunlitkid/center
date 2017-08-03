package com.sunlitkid.center.operator.timer;

import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by sunke on 2017/8/1.
 */
public class TestTimer2 {
    static List<Timer>  timers = new ArrayList<Timer>();
    static{
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Calendar calendar = Calendar.getInstance();
                System.out.println(calendar.getTime());
            }
        },1000,1000);
    }
    public static void main(String[] args) {
        Date date = new Date(1501578087171L);
        System.out.println(date);
    }
}
