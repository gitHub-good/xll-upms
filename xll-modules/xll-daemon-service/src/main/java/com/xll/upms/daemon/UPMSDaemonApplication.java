package com.xll.upms.daemon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author 徐亮亮
 * @Description： 分布式任务调度模块
 * @Date 2019/1/18 21:22
 */
@EnableDiscoveryClient
@SpringBootApplication
public class UPMSDaemonApplication {

    public static void main(String[] args) {
        SpringApplication.run(UPMSDaemonApplication.class, args);
    }

}
