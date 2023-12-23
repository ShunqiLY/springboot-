package com.qf.SpringBoot_backend.utils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
@Api(value = "CorsConfig跨域问题",description = "解决的两台服务器因不同域无法交互问题")
public class CorsConfig {

    private static final long MAX_AGE = 24*60*60;
    @ApiOperation("buildConfig 构建跨域问题")
    private CorsConfiguration buildConfig(){
        CorsConfiguration cors =new CorsConfiguration();
        cors.addAllowedOrigin("*");
        cors.addAllowedHeader("*");
        cors.addAllowedMethod("*");
        cors.setMaxAge(MAX_AGE);
        return cors;
    }
}
