package com.xll.upms.mc.listener;

import com.xll.upms.common.constant.MqQueueConstant;
import com.xll.upms.mc.handler.DingTalkMessageHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author 徐亮亮
 * @Description：  监听服务状态改变发送请求
 * @Date 2019/1/18 21:25
 */
@Slf4j
@Component
@RabbitListener(queues = MqQueueConstant.DINGTALK_SERVICE_STATUS_CHANGE)
public class DingTalkServiceChangeReceiveListener {
    @Autowired
    private DingTalkMessageHandler dingTalkMessageHandler;

    @RabbitHandler
    public void receive(String text) {
        long startTime = System.currentTimeMillis();
        log.info("消息中心接收到钉钉发送请求-> 内容：{} ", text);
        dingTalkMessageHandler.process(text);
        long useTime = System.currentTimeMillis() - startTime;
        log.info("调用 钉钉网关处理完毕，耗时 {}毫秒", useTime);
    }
}
