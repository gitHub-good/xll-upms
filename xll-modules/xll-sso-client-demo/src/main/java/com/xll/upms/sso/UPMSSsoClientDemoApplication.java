package com.xll.upms.sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;

/**
 * @Author 徐亮亮
 * @Description：  单点登录客户端
 * @Date 2019/1/18 21:27
 */
@EnableOAuth2Sso
@SpringBootApplication
public class UPMSSsoClientDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(UPMSSsoClientDemoApplication.class, args);
    }

}
