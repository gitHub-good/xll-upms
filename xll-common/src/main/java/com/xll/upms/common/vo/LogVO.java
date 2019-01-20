package com.xll.upms.common.vo;

import com.xll.upms.common.entity.SysLog;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author 徐亮亮
 * @Description： 日志视图实体类
 * @Date 2019/1/18 21:01
 */
@Data
public class LogVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private SysLog sysLog;
    private String username;
}
