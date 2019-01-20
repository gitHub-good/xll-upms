package com.xll.upms.gateway.service;

import com.netflix.zuul.context.RequestContext;

/**
 * @Author 徐亮亮
 * @Description：  日志发送业务逻辑
 * @Date 2019/1/18 21:17
 */
public interface LogSendService {
    /**
     * 往消息通道发消息
     *
     * @param requestContext requestContext
     */
    void send(RequestContext requestContext);
}
