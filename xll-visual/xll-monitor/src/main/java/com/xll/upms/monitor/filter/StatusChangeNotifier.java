package com.xll.upms.monitor.filter;

import com.alibaba.fastjson.JSONObject;
import com.xll.upms.common.constant.CommonConstant;
import com.xll.upms.common.constant.MqQueueConstant;
import com.xll.upms.common.constant.enums.EnumSmsChannelTemplate;
import com.xll.upms.common.util.template.MobileMsgTemplate;
import com.xll.upms.monitor.config.MonitorPropertiesConfig;
import com.xiaoleilu.hutool.collection.CollUtil;
import com.xiaoleilu.hutool.date.DateUtil;
import de.codecentric.boot.admin.event.ClientApplicationEvent;
import de.codecentric.boot.admin.event.ClientApplicationStatusChangedEvent;
import de.codecentric.boot.admin.notify.AbstractStatusChangeNotifier;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;


/**
 * @Author 徐亮亮
 * @Description：  服务下线通知
 * @Date 2019/1/18 22:06
 */
@Slf4j
public class StatusChangeNotifier extends AbstractStatusChangeNotifier {
    private RabbitTemplate rabbitTemplate;
    private MonitorPropertiesConfig monitorMobilePropertiesConfig;

    public StatusChangeNotifier(MonitorPropertiesConfig monitorMobilePropertiesConfig, RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        this.monitorMobilePropertiesConfig = monitorMobilePropertiesConfig;
    }

    /**
     * 通知逻辑
     *
     * @param event 事件
     * @throws Exception 异常
     */
    @Override
    protected void doNotify(ClientApplicationEvent event) {
        if (event instanceof ClientApplicationStatusChangedEvent) {
            log.info("Application {} ({}) is {}", event.getApplication().getName(),
                    event.getApplication().getId(), ((ClientApplicationStatusChangedEvent) event).getTo().getStatus());
            String text = String.format("应用:%s 服务ID:%s 状态改变为：%s，时间：%s"
                    , event.getApplication().getName()
                    , event.getApplication().getId()
                    , ((ClientApplicationStatusChangedEvent) event).getTo().getStatus()
                    , DateUtil.date(event.getTimestamp()).toString());

            JSONObject contextJson = new JSONObject();
            contextJson.put("name", event.getApplication().getName());
            contextJson.put("seid", event.getApplication().getId());
            contextJson.put("time", DateUtil.date(event.getTimestamp()).toString());

            //开启短信通知
            if (monitorMobilePropertiesConfig.getMobile().getEnabled()) {
                log.info("开始短信通知，内容：{}", text);
                rabbitTemplate.convertAndSend(MqQueueConstant.MOBILE_SERVICE_STATUS_CHANGE,
                        new MobileMsgTemplate(
                                CollUtil.join(monitorMobilePropertiesConfig.getMobile().getMobiles(), ","),
                                contextJson.toJSONString(),
                                CommonConstant.ALIYUN_SMS,
                                EnumSmsChannelTemplate.SERVICE_STATUS_CHANGE.getSignName(),
                                EnumSmsChannelTemplate.SERVICE_STATUS_CHANGE.getTemplate()
                        ));
            }

            if (monitorMobilePropertiesConfig.getDingTalk().getEnabled()) {
                log.info("开始钉钉通知，内容：{}", text);
                rabbitTemplate.convertAndSend(MqQueueConstant.DINGTALK_SERVICE_STATUS_CHANGE, text);
            }


        } else {
            log.info("Application {} ({}) {}", event.getApplication().getName(),
                    event.getApplication().getId(), event.getType());
        }
    }

}
