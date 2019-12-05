package com.util.http.autoconfig;

import com.util.http.service.CustomHttpService;
import com.util.http.sender.HttpClientSender;
import com.util.http.sender.OkHttpSender;
import okhttp3.OkHttpClient;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
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

    @Bean
    @ConditionalOnMissingBean
    public HttpClient httpClient(){
        return HttpClientBuilder.create().build();
    }

    @Bean
    @ConditionalOnMissingBean
    public OkHttpClient okHttpClient(){
        return new OkHttpClient();
    }

}
