package com.sunlitkid.center.operator.listener.task;

import java.util.Random;
import java.util.TimerTask;

/**
 * Created by sunke on 2017/8/8.
 */
public class TemperatureTask extends TimerTask{
    @Override
    public void run() {
        try{
            Float  temperature  = measure();
            if(temperature!=null){
                if(temperature<10){
                    System.out.println("温度过低");
                }
                if(temperature>20){
                    System.out.println("温度过高");
                }
            }
        }catch (Exception e){
            System.out.println("测量失败");
        }
    }

    private  Float measure(){
        Random random = new Random();
        return  random.nextInt(30)+random.nextFloat();
    }
}
