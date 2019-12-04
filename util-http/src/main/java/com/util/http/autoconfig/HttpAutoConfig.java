package com.util.http.autoconfig;

import com.util.http.sender.CustomHttpService;
import com.util.http.service.HttpClientSender;
import com.util.http.service.OkHttpSender;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * http模块自动配置
 * @author liangjinhui
 */
@Configuration
@EnableScheduling
public class HttpAutoConfig {

    @Bean
    @ConditionalOnMissingBean
    public CustomHttpService customHttpService(){
        return new CustomHttpService();
    }

    @Bean
    @ConditionalOnMissingBean
    public OkHttpSender okHttpSender(){
        return new OkHttpSender();
    }

    @Bean
    @ConditionalOnMissingBean
    public HttpClientSender httpClientSender(){
        return new HttpClientSender();
    }

}
