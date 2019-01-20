package com.xll.upms.admin.service;

import com.baomidou.mybatisplus.service.IService;
import com.xll.upms.common.entity.SysZuulRoute;

/**
 * @Author 徐亮亮
 * @Description：  动态路由配置表 服务类
 * @Date 2019/1/18 21:59
 */
public interface SysZuulRouteService extends IService<SysZuulRoute> {

    /**
     * 立即生效配置
     * @return
     */
    Boolean applyZuulRoute();
}
