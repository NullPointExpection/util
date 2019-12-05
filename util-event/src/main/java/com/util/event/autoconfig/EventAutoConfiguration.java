package com.util.event.autoconfig;

import com.util.event.publisher.EventPublisher;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

/**
 * 事件机制自动配置
 * @author liangjinhui
 */
public class EventAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public EventPublisher eventPublisher(){
        return new EventPublisher();
    }

}
