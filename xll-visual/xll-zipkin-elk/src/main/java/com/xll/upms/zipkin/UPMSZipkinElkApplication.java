package com.xll.upms.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import zipkin.server.EnableZipkinServer;

/**
 * @Author 徐亮亮
 * @Description：  链路追踪
 * @Date 2019/1/19 16:35
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableZipkinServer
public class UPMSZipkinElkApplication {

    public static void main(String[] args) {
        SpringApplication.run(UPMSZipkinElkApplication.class, args);
    }
}
