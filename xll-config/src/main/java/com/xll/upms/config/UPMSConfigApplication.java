package com.xll.upms.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Author 徐亮亮
 * @Description：  配置服务器中心
 * @Date 2019/1/18 21:03
 */
@EnableDiscoveryClient
@EnableConfigServer
@SpringBootApplication
public class UPMSConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(UPMSConfigApplication.class, args);
    }
}
