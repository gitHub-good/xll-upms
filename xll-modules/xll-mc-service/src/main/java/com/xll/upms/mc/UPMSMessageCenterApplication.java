package com.xll.upms.mc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author 徐亮亮
 * @Description：  消息中心
 * @Date 2019/1/18 21:25
 */
@EnableDiscoveryClient
@SpringBootApplication
public class UPMSMessageCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(UPMSMessageCenterApplication.class, args);
    }

}
