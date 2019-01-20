package com.xll.upms.common.bean.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author 徐亮亮
 * @Description：FastDFs参数
 * @Date 2019/1/18 20:33
 */
@Configuration
@ConditionalOnProperty(prefix = "fdfs", name = "file-host")
@ConfigurationProperties(prefix = "fdfs")
public class FdfsPropertiesConfig {
    private String fileHost;

    public String getFileHost() {
        return fileHost;
    }

    public void setFileHost(String fileHost) {
        this.fileHost = fileHost;
    }
}
