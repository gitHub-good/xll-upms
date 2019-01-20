package com.xll.upms.mc.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author 徐亮亮
 * @Description： 钉钉服务配置
 * @Date 2019/1/18 21:22
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "sms.dingtalk")
public class DingTalkPropertiesConfig {
    /**
     * webhook
     */
    private String webhook;

}
