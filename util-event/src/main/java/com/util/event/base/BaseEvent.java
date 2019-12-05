package com.util.event.base;

/**
 *
 * 基础事件
 * @author liangjinhui
 */
public abstract class BaseEvent {

    /**
     * 获取处理器名称
     * @return
     */
    public abstract String getHandlerName();

    /**
     * 获取事件类型
     * @return
     */
    public abstract String getEventType();

    /**
     * 获取事件描述
     * @return
     */
    public abstract String getEventDesc();

}
