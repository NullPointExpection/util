package com.util.http.sender;

import com.util.http.enumeration.RequestType;
import com.util.http.response.CustomHttpResponse;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.util.EntityUtils;
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
public class HttpClientSender extends BaseSender<HttpResponse> implements ISender {

    @Autowired
    private HttpClient httpClient;

    @Override
    public HttpResponse sendGet(String url, Map<String, String> header, Map<String, String> params) throws IOException {
        HttpGet httpGet = new HttpGet();
        createRequest(httpGet, url, header, params);
        return httpClient.execute(httpGet);
    }

    @Override
    public HttpResponse sendPost(String url, Map<String, String> header, Map<String, String> params) throws IOException {
        HttpPost httpPost = new HttpPost();
        createRequest(httpPost, url, header, params);
        return httpClient.execute(httpPost);

    }

    @Override
    public HttpResponse sendPut(String url, Map<String, String> header, Map<String, String> params) throws IOException {
        HttpPut httpPut = new HttpPut();
        createRequest(httpPut, url, header, params);
        return httpClient.execute(httpPut);
    }

    @Override
    public HttpResponse sendDelete(String url, Map<String, String> header, Map<String, String> params) throws IOException {
        HttpDelete httpDelete = new HttpDelete();
        createRequest(httpDelete, url, header, params);
        return httpClient.execute(httpDelete);
    }

    private void createRequest(HttpRequestBase httpRequestBase, String url, Map<String, String> header, Map<String, String> params) {
        URIBuilder uriBuilder;
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

    @Override
    protected CustomHttpResponse createResponse(HttpResponse httpResponse){
        if(httpResponse == null){
            log.error("[{}] [Send Http Response Is Null]",getClass().getSimpleName());
            return null;
        }
        CustomHttpResponse customHttpResponse = new CustomHttpResponse();
        customHttpResponse.setHttpCode(httpResponse.getStatusLine().getStatusCode());
        customHttpResponse.setMessage(httpResponse.getStatusLine().getReasonPhrase());
        try {
            String data = EntityUtils.toString(httpResponse.getEntity());
            customHttpResponse.setData(data);
        } catch (IOException e) {
            log.error("[{}] [Parse Http Response Error] [{}]",getClass().getSimpleName(),e);
        }
        return customHttpResponse;
    }

}
