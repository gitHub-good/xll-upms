package com.xll.upms.common.constant.enums;

/**
 * @Author 徐亮亮
 * @Description： 短信通道枚举
 * @Date 2019/1/18 20:47
 */
public enum EnumSmsChannel {
    /**
     * 阿里大鱼短信通道
     */
    ALIYUN("ALIYUN_SMS", "阿里大鱼");
    /**
     * 通道名称
     */
    private String name;
    /**
     * 通道描述
     */
    private String description;

    EnumSmsChannel(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
