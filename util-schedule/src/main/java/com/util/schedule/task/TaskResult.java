package com.util.schedule.task;


import lombok.Data;

/**
 * 任务执行结果
 * @author liangjinhui
 */
@Data
public class TaskResult {

    private boolean result;

    private String message;

    public static TaskResult success(){
        TaskResult taskResult = new TaskResult();
        taskResult.setResult(true);
        taskResult.setMessage("success");
        return taskResult;
    }

    public static TaskResult error(){
        TaskResult taskResult = new TaskResult();
        taskResult.setResult(false);
        taskResult.setMessage("error");
        return taskResult;
    }

}
