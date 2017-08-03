package com.sunlitkid.center.operator.timer;

import org.springframework.stereotype.Service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/**
 * Created by sunke on 2017/8/1.
 */
public class TestTimer {
    static{
        Runnable runnable = new Runnable(){
            public void run() {
                System.out.println("Hello !!");
            }
        };
        Runnable runnable2 = new Runnable(){
            public void run() {
                System.out.println("Hello 2!!");
            }
        };
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        // 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间
        service.scheduleAtFixedRate(runnable, 3, 3, TimeUnit.SECONDS);
        service.scheduleAtFixedRate(runnable2, 3, 3, TimeUnit.SECONDS);
        service.shutdown();
    }
}
