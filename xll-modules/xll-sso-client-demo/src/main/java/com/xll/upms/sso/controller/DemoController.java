package com.xll.upms.sso.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 徐亮亮
 * @Description： 测试
 * @Date 2019/1/18 21:26
 */
@RestController
public class DemoController {
    @GetMapping("/")
    public Authentication user(Authentication authentication) {
        return authentication;
    }
}
