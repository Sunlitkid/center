package com.sunlitkid.center.operator.timer;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * Created by sunke on 2017/8/1.
 */
public class CenterTimer {
    static Map<String,TimerTaskEntry> tasks = new HashMap<>();
    static Timer timer = new Timer();
    static {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                refreshTasks();
            }
        },new Date(),24*60*60*1000);
    }

    /**
     * 开启一个once任务
     * @param taskName
     * @param task
     * @param startDate
     * @return
     */
    public static JSONObject startTask(String taskName,TimerTask task, Date startDate){
        try{
            timer.schedule(task,startDate);
            TimerTaskEntry taskEntry =  new TimerTaskEntry(taskName,startDate,task);
            String uuid =UUID.randomUUID().toString();
            tasks.put(uuid,taskEntry);
            JSONObject json = new JSONObject();
            json.put(uuid,taskEntry);
            return json;
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }
    }

    /**
     * 开启一个loop任务
     * @param taskName
     * @param task
     * @param startDate
     * @param period
     * @return
     */
    public static JSONObject startTask(String taskName,TimerTask task, Date startDate,long period){
        try{
            timer.schedule(task,startDate,period);
            TimerTaskEntry taskEntry =  new TimerTaskEntry(taskName,startDate,task,period);
            String uuid =UUID.randomUUID().toString();
            tasks.put(uuid,taskEntry);
            JSONObject json = new JSONObject();
            json.put(uuid,taskEntry);
            return json;
        }catch (IllegalStateException e){
            e.printStackTrace();
            refreshTasks();
            restartTimer();
            return  null;
        }
    }

    /**
     * 根据uuid停止一个任务
     * @param uuid
     * @return
     */
    public static boolean stopTask(String uuid){
        TimerTaskEntry taskEntry =tasks.get(uuid);
        if(taskEntry==null){
            return false;
        }else{
            taskEntry.getTimerTask().cancel();
            tasks.remove(uuid);
            return  true;
        }
    }

    /**
     * 刷新全部任务
     * 一次性任务没执行的保留，执行了的删除
     * 循环任务不处理
     */
    public static void refreshTasks(){
        Map<String,TimerTaskEntry> newTasks = new HashMap<String,TimerTaskEntry>();
        for(Map.Entry<String,TimerTaskEntry> entry:tasks.entrySet()){
            if(entry.getValue().getPeriod()==null&&entry.getValue().getStartDate().before(new Date())){

            }else{
                newTasks.put(entry.getKey(),entry.getValue());
            }
        }
        tasks = newTasks;
    }

    /**
     * 重启全部任务
     */
    public static void restartTimer(){
        Timer newTimer = new Timer();
        for(Map.Entry<String,TimerTaskEntry> entry:tasks.entrySet()){
            if(entry.getValue().getPeriod()==null){//一次性任务
                if(entry.getValue().getStartDate().after(new Date())){
                    newTimer.schedule(entry.getValue().getTimerTask(),entry.getValue().getStartDate());
                }else{

                }
            }else{
                newTimer.schedule(entry.getValue().getTimerTask(),entry.getValue().getStartDate(),entry.getValue().getPeriod());
            }
        }
        timer.cancel();
        timer =newTimer;
    }


    public static Map<String,TimerTaskEntry> getTasks(){
        return  tasks;
    }
    private static class TimerTaskEntry{
        private String name;
        private Date startDate;
        private Long period;
        private TimerTask timerTask;

        public TimerTaskEntry(String name, Date startDate, TimerTask timerTask, long period) {
            this.name = name;
            this.startDate = startDate;
            this.timerTask = timerTask;
            this.period = period;
        }

       public TimerTaskEntry(String name, Date startDate, TimerTask timerTask) {
           this.name = name;
           this.startDate = startDate;
           this.timerTask = timerTask;
           this.period = null;
       }

        public Long getPeriod() {
            return period;
        }

        public void setPeriod(long period) {
            this.period = period;
        }

        public TimerTask getTimerTask() {
            return timerTask;
        }

        public void setTimerTask(TimerTask timerTask) {
            this.timerTask = timerTask;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Date getStartDate() {
            return startDate;
        }

        public void setStartDate(Date startDate) {
            this.startDate = startDate;
        }
    }


}
