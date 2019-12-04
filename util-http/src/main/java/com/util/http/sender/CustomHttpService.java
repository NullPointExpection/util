package com.util.http.sender;

import com.util.http.enumeration.SendClientType;
import com.util.http.request.CustomHttpRequest;
import com.util.http.response.CustomHttpResponse;
import com.util.http.service.HttpClientSender;
import com.util.http.service.OkHttpSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 自定义请求发送器
 * @author liangjinhui
 */
@Slf4j
public class CustomHttpService {

    @Autowired
    private OkHttpSender okHttpSender;

    @Autowired
    private HttpClientSender httpClientSender;

    /**
     * 发送Http请求
     * @param customHttpRequest
     * @return
     */
    public CustomHttpResponse send(CustomHttpRequest customHttpRequest){
        SendClientType sendClientType = customHttpRequest.getSendClientType();
        if(SendClientType.HttpClient.getClientType().equals(sendClientType.getClientType())){

        } else  if(SendClientType.OkHttp.getClientType().equals(sendClientType.getClientType())){

        } else {
            log.error("[{}] [Http Client Type Error]",getClass().getSimpleName());
            return null;
        }
        return null;
    }

}
