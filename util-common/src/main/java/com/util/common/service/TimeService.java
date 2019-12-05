package com.util.common.service;

import com.util.common.enumeration.TimeFormatType;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 有关事件的服务
 * @author liangjinhui
 */
public class TimeService {

    /**
     * 获取当前时间
     * @return
     */
    public long getNowTime(){
        return System.currentTimeMillis();
    }

    /**
     * 根据指定格式获取当前时间
     * @param timeFormatType
     * @return
     */
    public String getFormatTime(TimeFormatType timeFormatType){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(timeFormatType.getFormat());
        return simpleDateFormat.format(new Date());
    }


}
