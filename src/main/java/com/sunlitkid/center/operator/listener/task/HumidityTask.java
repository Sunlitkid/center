package com.sunlitkid.center.operator.listener.task;

import com.sunlitkid.center.config.HomeStatus;

import java.util.Random;
import java.util.TimerTask;

/**
 * Created by sunlitkid on 2017/8/8.
 */
public class HumidityTask extends TimerTask{
    @Override
    public void run() {
        try{
            Float  humidity  = measure();
            if(humidity!=null){
                if(humidity<10){
                    System.out.println("湿度过低");
                }
                if(humidity>20){
                    System.out.println("湿度过高");
                }
            }
            HomeStatus.setHumidity(humidity);
        }catch (Exception e){
            System.out.println("测量失败");
        }
    }
    private  Float measure(){
        Random random = new Random();
        return  random.nextInt(30)+random.nextFloat();
    }
}
