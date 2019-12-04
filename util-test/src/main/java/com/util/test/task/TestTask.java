package com.util.test.task;

import com.util.schedule.task.BaseTask;
import com.util.schedule.task.TaskResult;
import org.springframework.context.annotation.Configuration;

/**
 * 测试任务
 * @author liangjinhui
 */
@Configuration
public class TestTask extends BaseTask {
    @Override
    public String getTaskName() {
        return getClass().getSimpleName();
    }

    @Override
    public TaskResult execute() {
        System.out.println(1);
        return TaskResult.success();
    }

    @Override
    public int getInterval() {
        return 1000;
    }
}
