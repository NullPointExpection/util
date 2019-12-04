package com.util.test.task;

import com.util.http.sender.CustomHttpService;
import com.util.schedule.task.BaseTask;
import com.util.schedule.task.TaskResult;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    CustomHttpService customHttpService;

    @Override
    public TaskResult execute() {
        customHttpService.send(null);
        return TaskResult.success();
    }

    @Override
    public int getInterval() {
        return 1000;
    }
}
