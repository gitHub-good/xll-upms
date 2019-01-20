package com.xll.upms.common.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author 徐亮亮
 * @Description：spring boot 的异常对象视图实体类
 * @Date 2019/1/18 20:59
 */
@Data
public class ErrorPojo implements Serializable {

    @JSONField(name = "timestamp")
    private long timestamp;
    @JSONField(name = "status")
    private int status;
    @JSONField(name = "error")
    private String error;
    @JSONField(name = "exception")
    private String exception;
    @JSONField(name = "message")
    private String message;
    @JSONField(name = "path")
    private String path;
}
