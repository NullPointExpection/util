package com.util.http.sender;

import com.util.http.enumeration.RequestType;
import com.util.http.response.CustomHttpResponse;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Response;
import org.apache.http.client.methods.HttpRequestBase;

import java.io.IOException;
import java.util.Map;

/**
 * 基础发送类
 * @author liangjinhui
 */
@Slf4j
public abstract class BaseSender<T> {

    public CustomHttpResponse send(String url, String type, Map<String, String> header, Map<String, String> params){
        T response = null;
        try {
            if (RequestType.GET.getType().equals(type)) {
                response = sendGet(url, header,params);
            } else if (RequestType.POST.getType().equals(type)) {
                response = sendPost(url, header, params);
            } else if (RequestType.PUT.getType().equals(type)) {
                response = sendPut(url, header, params);
            } else if (RequestType.DELETE.getType().equals(type)) {
                response = sendDelete(url, header,params);
            } else {
                log.error("[{}] [Send Type Unsupport]", getClass().getSimpleName());
                return null;
            }
        } catch (IOException e) {
            log.error("[{}] [Send Error] [{}]", getClass().getSimpleName(),e);
        }
        return createResponse(response);
    }

    public abstract T sendGet(String url, Map<String, String> header, Map<String, String> params) throws IOException;

    public abstract T sendPost(String url, Map<String, String> header, Map<String, String> params) throws IOException;

    public abstract T sendPut(String url, Map<String, String> header, Map<String, String> params) throws IOException;

    public abstract T sendDelete(String url, Map<String, String> header, Map<String, String> params) throws IOException;

    protected abstract CustomHttpResponse createResponse(T response);

}
