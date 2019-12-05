package com.util.common.enumeration;

/**
 * 事件格式枚举类
 * @author liangjinhui
 */
public enum  TimeFormatType {

    /**
     * yyyy-MM-dd HH:mm:ss
     */
    YYYY_MM_DD_HH_MM_SS(1,"yyyy-MM-dd HH:mm:ss"),
    /**
     * yyyy-MM-dd HH:mm
     */
    YYY_MM_DD_HH_MM(2,"yyyy-MM-dd HH:mm"),
    /**
     * yyyy-MM-dd HH
     */
    YYY_MM_DD_HH(3,"yyyy-MM-dd HH"),
    /**
     * yyyy-MM-dd
     */
    YYYY_MM_DD(4,"yyyy-MM-dd"),
    /**
     * yyyy-MM
     */
    YYYY_MM(5,"yyyy-MM"),
    /**
     * yyyy
     */
    YYYY(6,"yyyy");

    TimeFormatType(int id,String format){
        this.id = id;
        this.format = format;
    }

    private int id;

    private String format;

    public String getFormat() {
        return format;
    }
}
