package com.xll.upms.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @Author 徐亮亮
 * @Description：  UPMS用户授权管理系统服务
 * @Date 2019/1/18 21:59
 */

@EnableAsync
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.xll.upms.admin", "com.xll.upms.common.bean"})
//@ComponentScan(basePackages = {"com.xll.upms"})
public class UPMSAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(UPMSAdminApplication.class, args);
    }
}