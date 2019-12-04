package com.util.http.enumeration;


/**
 * 发送客户端类型
 * @author liangjinhui
 */
public enum  SendClientType {

    /**
     * httpclient
     */
    HttpClient("httpClientSender"),

    /**
     * okhttp
     */
    OkHttp("okHttpSender");

    SendClientType(String clientType){
        this.clientType = clientType;
    }

    private String clientType;

    public String getClientType() {
        return clientType;
    }
}
