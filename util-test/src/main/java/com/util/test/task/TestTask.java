package com.util.test.task;

import com.alibaba.fastjson.JSON;
import com.util.event.publisher.EventPublisher;
import com.util.http.enumeration.RequestType;
import com.util.http.enumeration.SendClientType;
import com.util.http.request.CustomHttpRequest;
import com.util.http.response.CustomHttpResponse;
import com.util.http.service.CustomHttpService;
import com.util.schedule.task.BaseTask;
import com.util.schedule.task.TaskResult;
import com.util.test.event.TestEvent;
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

    @Autowired
    EventPublisher eventPublisher;

    @Override
    public TaskResult execute() {
//        CustomHttpRequest customHttpRequest = new CustomHttpRequest();
//        customHttpRequest.setUrl("https://www.baidu.com");
//        customHttpRequest.setRequestType(RequestType.GET);
//        customHttpRequest.setSendClientType(SendClientType.OkHttp);
//        CustomHttpResponse customHttpResponse = customHttpService.send(customHttpRequest);
//        System.out.println(JSON.toJSONString(customHttpResponse));
        eventPublisher.publishEvent(new TestEvent());
        return TaskResult.success();
    }

    @Override
    public int getInterval() {
        return 1000;
    }
}
