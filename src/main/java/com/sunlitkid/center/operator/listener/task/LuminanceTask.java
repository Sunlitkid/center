package com.sunlitkid.center.operator.listener.task;

import com.sunlitkid.center.config.HomeStatus;

import java.util.Random;
import java.util.TimerTask;

/**
 * Created by sunke on 2017/8/8.
 */
public class LuminanceTask extends TimerTask{
    @Override
    public void run() {
        try{
            Float  luminance  = measure();
            if(luminance!=null){
                if(luminance<10){
                    System.out.println("亮度过低");
                }
                if(luminance>20){
                    System.out.println("亮度过高");
                }
            }
            HomeStatus.setLuminance(luminance);
        }catch (Exception e){
            System.out.println("测量失败");
        }
    }
    private  Float measure(){
        Random random = new Random();
        return  random.nextInt(30)+random.nextFloat();
    }
}
