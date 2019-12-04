package com.util.http.service;

import com.util.http.response.CustomHttpResponse;

import java.util.Map;

/**
 * @author liangjinhui
 */
public class OkHttpSender implements ISender{


    @Override
    public CustomHttpResponse send(String url, String type, Map<String, Object> header, Map<String, Object> params) {

        return null;
    }

    public void sendGet(String url, Map<String, Object> header, Map<String,Object> params) {

    }

    public void sendPost(String url, Map<String, Object> header, Map<String, Object> params) {

    }

    public void sendPut(String url, Map<String, Object> header, Map<String, Object> params) {

    }

    public void sendDelete(String url, Map<String, Object> header, Map<String, Object> params) {

    }
}
