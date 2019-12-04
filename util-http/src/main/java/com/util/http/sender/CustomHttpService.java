package com.util.http.sender;

import com.util.http.enumeration.RequestType;
import com.util.http.enumeration.SendClientType;
import com.util.http.request.CustomHttpRequest;
import com.util.http.response.CustomHttpResponse;
import com.util.http.service.ISender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * 自定义请求发送器
 * @author liangjinhui
 */
@Slf4j
public class CustomHttpService {

    @Autowired
    private Map<String, ISender> httpSenderMap;

    /**
     * 发送Http请求
     * @param customHttpRequest
     * @return
     */
    public CustomHttpResponse send(CustomHttpRequest customHttpRequest){
        if(customHttpRequest == null){
            log.error("[{}] [Http Request Is Null]",getClass().getSimpleName());
            return null;
        }
        SendClientType sendClientType = customHttpRequest.getSendClientType();
        ISender iSender = httpSenderMap.get(sendClientType.getClientType());
        if(iSender == null){
            log.error("[{}] [Http Client Type Error]",getClass().getSimpleName());
            return null;
        }
        String url = customHttpRequest.getUrl();
        RequestType requestType = customHttpRequest.getRequestType();
        Map<String,String> params = customHttpRequest.getParams();
        Map<String,String> headers = customHttpRequest.getHeader();
        return iSender.send(url,requestType.getType(),headers,params);
    }

}
