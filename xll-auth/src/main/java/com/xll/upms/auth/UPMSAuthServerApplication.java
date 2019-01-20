package com.xll.upms.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author 徐亮亮
 * @Description： 获取用户信息也是通过这个应用实现
 *                 这里既是认证服务器，也是资源服务器
 * @Date 2019/1/18 20:08
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@ComponentScan(basePackages = {"com.xll.upms.auth", "com.xll.upms.common.bean"})
public class UPMSAuthServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(UPMSAuthServerApplication.class, args);
    }

}
