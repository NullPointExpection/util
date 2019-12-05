package com.util.http.sender;

import com.alibaba.fastjson.JSON;
import com.util.http.response.CustomHttpResponse;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Map;

/**
 * @author liangjinhui
 */
@Slf4j
public class OkHttpSender extends BaseSender<Response> implements ISender {

    @Autowired
    private OkHttpClient okHttpClient;

    public static final MediaType JSON_TYPE = MediaType.parse("application/json; charset=utf-8");

    @Override
    public Response sendGet(String url, Map<String, String> header, Map<String, String> params) throws IOException {
        Request.Builder request = createRequest(url, header);
        Call call = okHttpClient.newCall(request.get().build());
        return call.execute();
    }

    @Override
    public Response sendPost(String url, Map<String, String> header, Map<String, String> params) throws IOException {
        Request.Builder request = createRequest(url, header);
        RequestBody requestBody = createRequestBody(JSON_TYPE,params);
        Call call = okHttpClient.newCall(request.post(requestBody).build());
        return call.execute();
    }

    @Override
    public Response sendPut(String url, Map<String, String> header, Map<String, String> params) throws IOException {
        Request.Builder request = createRequest(url, header);
        RequestBody requestBody = createRequestBody(JSON_TYPE,params);
        Call call = okHttpClient.newCall(request.put(requestBody).build());
        return call.execute();
    }

    @Override
    public Response sendDelete(String url, Map<String, String> header, Map<String, String> params) throws IOException {
        Request.Builder request = createRequest(url, header);
        Call call = okHttpClient.newCall(request.delete().build());
        return call.execute();
    }

    private Request.Builder createRequest(String url, Map<String, String> header) {
        Request.Builder request = new Request.Builder();
        request.url(url);
        if(header != null){
            for(String key : header.keySet()){
                request.addHeader(key,header.get(key));
            }
        }
        return request;
    }

    private RequestBody createRequestBody(MediaType mediaType,Map<String, String> params){
        return RequestBody.create(JSON.toJSONString(params),mediaType);
    }

    @Override
    protected CustomHttpResponse createResponse(Response response) {
        if(response == null){
            log.error("[{}] [Send Http Response Is Null]",getClass().getSimpleName());
            return null;
        }
        CustomHttpResponse customHttpResponse = new CustomHttpResponse();
        customHttpResponse.setHttpCode(response.code());
        customHttpResponse.setMessage(response.message());
        try {
            ResponseBody responseBody = response.body();
            if(responseBody != null){
                customHttpResponse.setData(responseBody.string());
            } else {
                log.error("[{}] [ResponseBody Is Null]",getClass().getSimpleName());
            }
        } catch (IOException e) {
            log.error("[{}] [Parse Http Response Error] [{}]",getClass().getSimpleName(),e);
        }
        return customHttpResponse;
    }

}
