package com.xll.upms.gateway.util;

import com.alibaba.ttl.TransmittableThreadLocal;

/**
 * @Author 徐亮亮
 * @Description： 负载均衡处理器
 * @Date 2019/1/18 21:19
 */
public class RibbonVersionHolder {
    private static final ThreadLocal<String> context = new TransmittableThreadLocal<>();


    public static String getContext() {
        return context.get();
    }

    public static void setContext(String value) {
        context.set(value);
    }

    public static void clearContext() {
        context.remove();
    }
}
