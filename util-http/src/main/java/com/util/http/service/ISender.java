package com.util.http.service;

import com.util.http.response.CustomHttpResponse;

import java.util.Map;

/**
 * 抽象发送器
 * @author liangjinhui
 */
public interface ISender {

    /**
     * 发送数据
     * @param url
     * @param header
     * @param params
     */
    CustomHttpResponse send(String url, String type , Map<String,String> header, Map<String,String> params);


}
