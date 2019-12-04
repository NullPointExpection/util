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

    @Override
    public void sendGet(String url, Map<String, Object> header) {

    }

    @Override
    public void sendPost(String url, Map<String, Object> header, Map<String, Object> params) {

    }

    @Override
    public void sendPut(String url, Map<String, Object> header, Map<String, Object> params) {

    }

    @Override
    public void sendDelete(String url, Map<String, Object> header, Map<String, Object> params) {

    }
}
