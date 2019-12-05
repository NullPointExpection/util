package com.util.thread.autoconfig;

import com.util.thread.properties.ThreadProperties;
import com.util.thread.scheduler.ThreadScheduler;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自动配置
 * @author liangjinhui
 */
@Configuration
@EnableConfigurationProperties(ThreadProperties.class)
public class ThreadAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public ThreadScheduler threadScheduler(){
        return new ThreadScheduler();
    }

}
