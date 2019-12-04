package com.util.schedule.autoconfig;

import com.util.schedule.schedule.ControlSchedule;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 自动化配置
 * @author liangjinhui
 */
@Configuration
@EnableScheduling
public class ScheduleAutoConfig {

    @Bean
    @ConditionalOnMissingBean
    public ControlSchedule controlSchedule(){
        return new ControlSchedule();
    }

}
