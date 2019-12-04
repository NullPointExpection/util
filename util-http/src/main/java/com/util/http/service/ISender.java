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
    CustomHttpResponse send(String url, String type , Map<String,Object> header, Map<String,Object> params);

    void sendGet(String url,Map<String,Object> header);
    void sendPost(String url,Map<String,Object> header, Map<String,Object> params);
    void sendPut(String url,Map<String,Object> header, Map<String,Object> params);
    void sendDelete(String url,Map<String,Object> header, Map<String,Object> params);

}
