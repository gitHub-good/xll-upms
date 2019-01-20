package com.xll.upms.admin.service;

import com.baomidou.mybatisplus.service.IService;
import com.xll.upms.common.entity.SysLog;

/**
 * @Author 徐亮亮
 * @Description：  日志表 服务类
 * @Date 2019/1/18 21:56
 */
public interface SysLogService extends IService<SysLog> {

    /**
     * 通过ID删除日志（逻辑删除）
     *
     * @param id 日志ID
     * @return true/false
     */
    Boolean updateByLogId(Long id);
}
