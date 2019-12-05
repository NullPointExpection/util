package com.util.event.handler;

import com.util.event.base.BaseEvent;
import lombok.extern.slf4j.Slf4j;

/**
 * 事件处理机制
 * @author liangjinhui
 */
@Slf4j
public abstract class BaseEventHandler {

    public void handle(BaseEvent baseEvent){
        log.info("[{}] [Default Handle] [type: {}] [desc: {}]",getClass().getSimpleName(),baseEvent.getEventType(),baseEvent.getEventDesc());
    }

}
