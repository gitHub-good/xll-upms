package com.xll.upms.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import zipkin.server.EnableZipkinServer;

/**
 * @Author 徐亮亮
 * @Description：  zipkin mysql 存储实现
 * @Date 2019/1/18 22:06
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableZipkinServer
public class UPMSZipkinDbApplication {
    public static void main(String[] args) {
        SpringApplication.run(UPMSZipkinDbApplication.class, args);
    }
}
