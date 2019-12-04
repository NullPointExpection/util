package com.util.http.enumeration;


public enum  SendClientType {

    /**
     * httpclient
     */
    HttpClient("HttpClient"),

    /**
     * okhttp
     */
    OkHttp("OkHttp");

    SendClientType(String clientType){
        this.clientType = clientType;
    }

    private String clientType;

    public String getClientType() {
        return clientType;
    }
}
