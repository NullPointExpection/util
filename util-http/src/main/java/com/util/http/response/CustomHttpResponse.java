package com.util.http.response;

import lombok.Data;

/**
 * 自定义http响应
 * @author liangjinhui
 */
@Data
public class CustomHttpResponse {

    private int httpCode;

    private String message;

    private String data;

}
