package com.kochun.wxmp.webapi.config;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author kk
 * MybatisPlus配置类
 */
@EnableTransactionManagement
@Configuration
@MapperScan(value = "com.kochun.wxmp.back.mapper.*")
public class MybatisPlusConfig {

    /**
     * 性能分析拦截器，不建议生产使用 用来观察 SQL 执行情况及执行时长, 默认dev,staging 环境开启
     *
     * @return com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
     * @author fxbin
     */
    @Bean
    @Profile({"dev", "staging"})
    public PerformanceInterceptor performanceInterceptor() {

        //启用性能分析插件, SQL是否格式化 默认false,此处开启
        return new PerformanceInterceptor().setFormat(true);
    }


    /**
     * 分页插件
     *
     * @return com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor
     * @author fxbin
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor.setDialectType("mysql");
        return paginationInterceptor;
    }

    /**
     * 乐观锁插件
     * @return
     */
    public OptimisticLockerInterceptor optimisticLockerInterceptor(){
        return new OptimisticLockerInterceptor();
    }
}

