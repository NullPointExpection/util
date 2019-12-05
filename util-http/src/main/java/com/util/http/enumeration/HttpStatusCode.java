package com.util.http.enumeration;

/**
 * http请求码对应的自定义请求码
 * @author liangjinhui
 */
public enum  HttpStatusCode {

    /**
     * 成功
     */
    SUCCESS(200),
    /**
     * 错误
     */
    ERROR(500),
    /**
     * url错误
     */
    NOT_FIND(404);

    HttpStatusCode(int httpCode){
        this.httpCode = httpCode;
    }

    private int httpCode;

}
