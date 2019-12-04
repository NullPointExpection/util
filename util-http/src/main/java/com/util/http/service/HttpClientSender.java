package com.util.http.service;

import com.util.http.enumeration.RequestType;
import com.util.http.response.CustomHttpResponse;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

/**
 * HTTPClient 发送器
 *
 * @author liangjinhui
 */
@Slf4j
public class HttpClientSender implements ISender {

    @Autowired
    private HttpClient httpClient;

    @Override
    public CustomHttpResponse send(String url, String type, Map<String, String> header, Map<String, String> params) {
        HttpResponse httpResponse  = null;
        if(RequestType.GET.getType().equals(type)){
            httpResponse = sendGet(url,header,params);
        } else if(RequestType.POST.getType().equals(type)){
            httpResponse = sendPost(url,header,params);
        } else if(RequestType.PUT.getType().equals(type)){
            httpResponse = sendPut(url,header,params);
        } else if(RequestType.DELETE.getType().equals(type)){
            httpResponse = sendDelete(url, header, params);
        } else {
            log.error("[{}] [Send Type Unsupport]",getClass().getSimpleName());
        }
        return createResponse(httpResponse);
    }

    public HttpResponse sendGet(String url, Map<String, String> header, Map<String, String> params) {
        if (url == null) {
            return null;
        }
        HttpGet httpGet = new HttpGet();
        createRequest(httpGet, url, header, params);
        try {
            return httpClient.execute(httpGet);
        } catch (IOException e) {
            log.error("[{}] [Send Get Request Error] [{}]", getClass().getSimpleName(), e);
        }
        return null;
    }

    public HttpResponse sendPost(String url, Map<String, String> header, Map<String, String> params) {
        HttpPost httpPost = new HttpPost();
        createRequest(httpPost, url, header, params);
        try {
            return httpClient.execute(httpPost);
        } catch (IOException e) {
            log.error("[{}] [Send Post Request Error] [{}]", getClass().getSimpleName(), e);
        }
        return null;
    }

    public HttpResponse sendPut(String url, Map<String, String> header, Map<String, String> params) {
        HttpPut httpPut = new HttpPut();
        createRequest(httpPut, url, header, params);
        try {
            return httpClient.execute(httpPut);
        } catch (IOException e) {
            log.error("[{}] [Send Put Request Error] [{}]", getClass().getSimpleName(), e);
        }
        return null;
    }

    public HttpResponse sendDelete(String url, Map<String, String> header, Map<String, String> params) {
        HttpDelete httpDelete = new HttpDelete();
        createRequest(httpDelete, url, header, params);
        try {
            return httpClient.execute(httpDelete);
        } catch (IOException e) {
            log.error("[{}] [Send Delete Request Error] [{}]", getClass().getSimpleName(), e);
        }
        return null;
    }

    private void createRequest(HttpRequestBase httpRequestBase, String url, Map<String, String> header, Map<String, String> params) {
        URIBuilder uriBuilder = null;
        try {
            uriBuilder = new URIBuilder(url);
            if (params != null) {
                for (String key : params.keySet()) {
                    uriBuilder.addParameter(key, params.get(key));
                }
            }
            httpRequestBase.setURI(uriBuilder.build());
            if (header != null) {
                for (String key : header.keySet()) {
                    httpRequestBase.addHeader(key, header.get(key));
                }
            }
        } catch (URISyntaxException e) {
            log.error("[{}] [Create Request Error] [{}]", getClass().getSimpleName(), e);
        }
    }

    private CustomHttpResponse createResponse( HttpResponse httpResponse){
        if(httpResponse == null){
            log.error("[{}] [Send Http Response Is Null]",getClass().getSimpleName());
            return null;
        }
        CustomHttpResponse customHttpResponse = new CustomHttpResponse();
        return null;
    }

}
