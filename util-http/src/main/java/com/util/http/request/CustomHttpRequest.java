package com.util.http.request;

import com.util.http.enumeration.SendClientType;
import lombok.Data;

import java.util.Map;

/**
 * 自定义http请求
 * @author liangjinhui
 */
@Data
public class CustomHttpRequest {

    private SendClientType sendClientType;

    private String url;

    private Map<String,String> header;

    private Map<String,String> params;


}
