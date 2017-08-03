package com.sunlitkid.center.common.bean;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by sunke on 2017/8/1.
 */
public class Task {
    static final int CYCLE_TYPE_ONCE= 1;
    static final int CYCLE_TYPE_LOOP= 2;

    //body是命令
    static final int TARGET_TYPE_SELF= 1;
    static final int TARGET_TYPE_CONTROLLER = 2; //target是控制器路径
    //body是信息
    static final int TARGET_TYPE_WECHAT = 3; //target是我的微信号
    static final int TARGET_TYPE_TELEPHONE = 4;//target是我的phoneNumber

    private int cycleType ;
    private int targetType ;
    private long period ; //周期
    private TimeUnit timeUnit ; //时间单位
    private Date startTime;
    private String body;
    private String target;


    /**
     *
     * @param cycleType  循环或单次
     * @param targetType  任务目标类型
     * @param target  任务目标
     * @param period    循环周期
     * @param timeUnit  循环周期的时间单位
     * @param startTime  开始时间
     * @param body  任务主体
     */
    public Task(int cycleType, int targetType, String target, long period, TimeUnit timeUnit, Date startTime, String body) {
        this.cycleType = cycleType;
        this.targetType = targetType;
        this.target = target;
        this.period = period;
        this.timeUnit = timeUnit;
        this.startTime = startTime;
        this.body = body;
    }

    public int getCycleType() {
        return cycleType;
    }

    public void setCycleType(int cycleType) {
        this.cycleType = cycleType;
    }

    public int getTargetType() {
        return targetType;
    }

    public void setTargetType(int targetType) {
        this.targetType = targetType;
    }

    public long getPeriod() {
        return period;
    }

    public void setPeriod(long period) {
        this.period = period;
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
}
