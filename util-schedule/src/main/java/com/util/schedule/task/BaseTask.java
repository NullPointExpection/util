package com.util.schedule.task;

/**
 * @author liangjinhui
 */
public abstract class BaseTask {

    public abstract String getTaskName();

    public abstract TaskResult execute();

    public int getInterval(){
        return 60 * 1000;
    }

}
