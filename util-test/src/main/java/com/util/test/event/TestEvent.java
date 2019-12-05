package com.util.test.event;

import com.util.event.base.BaseEvent;

/**
 * 测试事件
 * @author liangjinhui
 */
public class TestEvent extends BaseEvent {
    @Override
    public String getHandlerName() {
        return "testHandler";
    }

    @Override
    public String getEventType() {
        return "test";
    }

    @Override
    public String getEventDesc() {
        return "测试的事件描述";
    }
}
