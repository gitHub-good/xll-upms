package com.xll.upms.admin.common.config;

import com.xll.upms.common.constant.MqQueueConstant;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author 徐亮亮
 * @Description：  rabbit初始化配置
 * @Date 2019/1/18 21:30
 */
@Configuration
public class RabbitConfig {
    /**
     * 初始化 log队列
     *
     * @return
     */
    @Bean
    public Queue initLogQueue() {
        return new Queue(MqQueueConstant.LOG_QUEUE);
    }

    /**
     * 初始化 手机验证码通道
     *
     * @return
     */
    @Bean
    public Queue initMobileCodeQueue() {
        return new Queue(MqQueueConstant.MOBILE_CODE_QUEUE);
    }

    /**
     * 初始化服务状态改变队列
     *
     * @return
     */
    @Bean
    public Queue initMobileServiceStatusChangeQueue() {
        return new Queue(MqQueueConstant.MOBILE_SERVICE_STATUS_CHANGE);
    }

    /**
     * 初始化钉钉状态改变队列
     *
     * @return
     */
    @Bean
    public Queue initDingTalkServiceStatusChangeQueue() {
        return new Queue(MqQueueConstant.DINGTALK_SERVICE_STATUS_CHANGE);
    }

    /**
     * 初始化zipkin队列
     *
     * @return
     */
    @Bean
    public Queue initZipkinQueue() {
        return new Queue(MqQueueConstant.ZIPKIN_NAME_QUEUE);
    }

    /**
     * 初始化路由配置状态队列
     *
     * @return
     */
    @Bean
    public Queue initRouteConfigChangeQueue() {
        return new Queue(MqQueueConstant.ROUTE_CONFIG_CHANGE);
    }
}
