package com.xll.upms.monitor.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author 徐亮亮
 * @Description：  监控属性配置类
 * @Date 2019/1/18 22:04
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "notifier")
public class MonitorPropertiesConfig {

    private MonitorMobilePropertiesConfig mobile;

    private MonitorDingTalkPropertiesConfig dingTalk;

}
