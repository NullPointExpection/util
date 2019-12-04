package com.util.http.response;

import lombok.Data;

/**
 * 自定义http响应
 * @author liangjinhui
 */
@Data
public class CustomHttpResponse {

    private int httpCode;

    private int customCode;

    private String message;

    private String data;

}
