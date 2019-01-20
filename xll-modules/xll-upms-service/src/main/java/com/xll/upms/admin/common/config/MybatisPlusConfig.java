package com.xll.upms.admin.common.config;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.xll.upms.common.bean.interceptor.DataScopeInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author 徐亮亮
 * @Description：Mapper映射文件配置类
 * @Date 2019/1/18 21:30
 */
@Configuration
@MapperScan("com.xll.upms.admin.mapper")
public class MybatisPlusConfig {
    /**
     * 分页插件
     *
     * @return PaginationInterceptor
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    /**
     * 数据权限插件
     *
     * @return DataScopeInterceptor
     */
    @Bean
    public DataScopeInterceptor dataScopeInterceptor() {
        return new DataScopeInterceptor();
    }
}