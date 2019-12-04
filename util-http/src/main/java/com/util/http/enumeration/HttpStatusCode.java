package com.util.http.enumeration;

/**
 * http请求码对应的自定义请求码
 * @author liangjinhui
 */
public enum  HttpStatusCode {

    /**
     * 成功
     */
    SUCCESS(200,1),
    /**
     * 错误
     */
    ERROR(500,2),
    /**
     * url错误
     */
    NOT_FIND(404,3);

    HttpStatusCode(int httpCode,int customCode){
        this.httpCode = httpCode;
        this.customCode = customCode;
    }

    private int httpCode;

    private int customCode;

}
