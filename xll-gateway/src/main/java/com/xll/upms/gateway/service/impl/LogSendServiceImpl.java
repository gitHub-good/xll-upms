package com.xll.upms.gateway.service.impl;

import com.xll.upms.common.constant.CommonConstant;
import com.xll.upms.common.constant.MqQueueConstant;
import com.xll.upms.common.entity.SysLog;
import com.xll.upms.common.vo.LogVO;
import com.xll.upms.gateway.service.LogSendService;
import com.netflix.zuul.context.RequestContext;
import com.xiaoleilu.hutool.http.HttpUtil;
import com.xiaoleilu.hutool.io.IoUtil;
import com.xiaoleilu.hutool.util.StrUtil;
import com.xiaoleilu.hutool.util.URLUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author 徐亮亮
 * @Description：  消息发往消息队列工具类
 * @Date 2019/1/18 21:16
 */
@Slf4j
@Component
public class LogSendServiceImpl implements LogSendService {
    private static final String SERVICE_ID = "serviceId";
    @Autowired
    private AmqpTemplate rabbitTemplate;

    /**
     * 1. 获取 requestContext 中的请求信息
     * 2. 如果返回状态不是OK，则获取返回信息中的错误信息
     * 3. 发送到MQ
     *
     * @param requestContext 上下文对象
     */
    @Override
    public void send(RequestContext requestContext) {
        HttpServletRequest request = requestContext.getRequest();
        String requestUri = request.getRequestURI();
        String method = request.getMethod();
        SysLog sysLog = new SysLog();
        sysLog.setType(CommonConstant.STATUS_NORMAL);
        sysLog.setRemoteAddr(HttpUtil.getClientIP(request));
        sysLog.setRequestUri(URLUtil.getPath(requestUri));
        sysLog.setMethod(method);
        sysLog.setUserAgent(request.getHeader("user-agent"));
        sysLog.setParams(HttpUtil.toParams(request.getParameterMap()));
        Long startTime = (Long) requestContext.get("startTime");
        sysLog.setTime(System.currentTimeMillis() - startTime);
        if (requestContext.get(SERVICE_ID) != null) {
            sysLog.setServiceId(requestContext.get(SERVICE_ID).toString());
        }

        //正常发送服务异常解析
        if (requestContext.getResponseStatusCode() == HttpStatus.SC_INTERNAL_SERVER_ERROR
                && requestContext.getResponseDataStream() != null) {
            InputStream inputStream = requestContext.getResponseDataStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            InputStream stream1 = null;
            InputStream stream2;
            byte[] buffer = IoUtil.readBytes(inputStream);
            try {
                baos.write(buffer);
                baos.flush();
                stream1 = new ByteArrayInputStream(baos.toByteArray());
                stream2 = new ByteArrayInputStream(baos.toByteArray());
                String resp = IoUtil.read(stream1, CommonConstant.UTF8);
                sysLog.setType(CommonConstant.STATUS_LOCK);
                sysLog.setException(resp);
                requestContext.setResponseDataStream(stream2);
            } catch (IOException e) {
                log.error("响应流解析异常：", e);
                throw new RuntimeException(e);
            } finally {
                IoUtil.close(stream1);
                IoUtil.close(baos);
                IoUtil.close(inputStream);
            }
        }

        //网关内部异常
        Throwable throwable = requestContext.getThrowable();
        if (throwable != null) {
            log.error("网关异常", throwable);
            sysLog.setException(throwable.getMessage());
        }
        //保存发往MQ（只保存授权）
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && StrUtil.isNotBlank(authentication.getName())) {
            LogVO logVo = new LogVO();
            sysLog.setCreateBy(authentication.getName());
            logVo.setSysLog(sysLog);
            logVo.setUsername(authentication.getName());
            rabbitTemplate.convertAndSend(MqQueueConstant.LOG_QUEUE, logVo);
        }
    }
}
