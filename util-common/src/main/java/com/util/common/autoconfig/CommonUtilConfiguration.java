package com.util.common.autoconfig;

import com.util.common.service.TimeService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 通用工具配置
 * @author liangjinhui
 */
@Configuration
public class CommonUtilConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public TimeService timeService(){
        return new TimeService();
    }

}
