package com.xll.upms.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author 徐亮亮
 * @Description：服务注册与服务发现
 * @Date 2019/1/18 21:04
 */
@EnableEurekaServer
@SpringBootApplication
public class UPMSEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(UPMSEurekaApplication.class, args);
	}
}
