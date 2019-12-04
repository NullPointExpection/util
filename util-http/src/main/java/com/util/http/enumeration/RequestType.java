package com.util.http.enumeration;


/**
 * 请求方式
 * @author liangjinhui
 */
public enum RequestType {


    /**
     * post
     */
    POST("post"),
    /**
     * get
     */
    GET("get"),
    /**
     * put
     */
    PUT("put"),
    /**
     * delete
     */
    DELETE("delete");

    RequestType(String type){
        this.type = type;
    }

    private String type;

    public String getType() {
        return type;
    }
}
