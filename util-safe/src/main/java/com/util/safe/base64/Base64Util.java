package com.util.safe.base64;


import java.util.Base64;

/**
 * base64工具
 * @author liangjinhui
 */
public class Base64Util {

    public String toBase64(String text){
        if(text == null){
            return null;
        }
        Base64.Encoder encoder = Base64.getEncoder();
        return new String (encoder.encode(text.getBytes()));
    }

    public String parseBase64(String base64){
        if(base64 == null){
            return null;
        }
        Base64.Decoder decoder = Base64.getDecoder();
        return new String (decoder.decode(base64.getBytes()));
    }

}
