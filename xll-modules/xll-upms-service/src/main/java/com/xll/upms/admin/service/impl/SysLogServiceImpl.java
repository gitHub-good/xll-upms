package com.xll.upms.admin.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.xll.upms.admin.mapper.SysLogMapper;
import com.xll.upms.admin.service.SysLogService;
import com.xll.upms.common.constant.CommonConstant;
import com.xll.upms.common.entity.SysLog;
import com.xll.upms.common.util.Assert;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @Author 徐亮亮
 * @Description：  日志表 服务实现类
 * @Date 2019/1/18 21:52
 */
@Service
@Transactional
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements SysLogService {

    @Override
    public Boolean updateByLogId(Long id) {
        Assert.isNull(id, "日志ID为空");

        SysLog sysLog = new SysLog();
        sysLog.setId(id);
        sysLog.setDelFlag(CommonConstant.STATUS_DEL);
        sysLog.setUpdateTime(new Date());
        return updateById(sysLog);
    }
}
