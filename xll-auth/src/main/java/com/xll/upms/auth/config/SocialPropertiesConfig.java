package com.xll.upms.auth.config;

import lombok.Data;

/**
 * @Author 徐亮亮
 * @Description：  登录基础配置
 * @Date 2019/1/18 20:27
 */
@Data
public class SocialPropertiesConfig {
    /**
     * 提供商
     */
    private String providerId;
    /**
     * 应用ID
     */
    private String clientId;
    /**
     * 应用密钥
     */
    private String clientSecret;

}
