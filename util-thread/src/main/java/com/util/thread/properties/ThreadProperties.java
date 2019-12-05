package com.util.thread.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * 配置属性
 * @author liangjinhui
 */
@Data
@Configuration
@ConfigurationProperties("util.thread")
public class ThreadProperties {

    Map<String,Integer> threadCountConfig = new HashMap<>();

}
