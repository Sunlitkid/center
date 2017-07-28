package com.sunlitkid.center.common.bean;

/**
 * Created by sunke on 2017/7/27.
 */
public class Command {
    private  String command;
    public Command(String command){
        this.command = command ;
    }
    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    @Override
    public String toString() {
        return command;
    }
}
