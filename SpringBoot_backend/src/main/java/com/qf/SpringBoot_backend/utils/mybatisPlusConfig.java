package com.qf.SpringBoot_backend.utils;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.qf.SpringBoot_backend.mapper")
@Api("MybatisPlusConfig配置")
public class mybatisPlusConfig {
    //分页工具
    @Bean
    @ApiOperation("mybatisPlusInterceptor 分页工具")
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        MybatisPlusInterceptor interceptor =new MybatisPlusInterceptor();

        //添加1个使用插件用于做分页
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));



        return interceptor;
    }

}
