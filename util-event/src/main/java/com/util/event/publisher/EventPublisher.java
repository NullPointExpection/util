package com.util.event.publisher;

import com.alibaba.fastjson.JSON;
import com.util.event.base.BaseEvent;
import com.util.event.handler.BaseEventHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * 事件发布者
 * @author liangjinhui
 */
@Slf4j
public class EventPublisher {

    @Autowired(required = false)
    private Map<String, BaseEventHandler> handlerMap;

    private void handleEvent(BaseEvent baseEvent){
        if(handlerMap == null){
            log.error("[{}] [Handler Map Not Exist]",getClass().getSimpleName());
            return;
        }else {
            BaseEventHandler baseEventHandler = handlerMap.get(baseEvent.getHandlerName());
            if(baseEventHandler == null){
                log.error("[{}] [Handler Not Exist] [Handler:{}]",getClass().getSimpleName(),baseEvent.getHandlerName());
                return ;
            }
            baseEventHandler.handle(baseEvent);
        }
    }

    /**
     * 发布事件
     * @param baseEvent
     */
    public void publishEvent(BaseEvent baseEvent){
        handleEvent(baseEvent);
    }


}
