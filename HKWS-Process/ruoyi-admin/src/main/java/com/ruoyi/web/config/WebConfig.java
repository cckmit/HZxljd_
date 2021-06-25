package com.ruoyi.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.web.config
 * @ClassName: WebConfig
 * @Author: guohailong
 * @Description: 配置拦截器
 * @Date: 2021/3/13 2:06
 * @Version: 1.0
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * 配置跨域请求
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedHeaders("*")
                .allowedMethods("*");
    }

    /**
     * 拦截器 只适用于浙政钉接口
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JWTInterceptor())
                .addPathPatterns("/ding/**")//拦截所以/ding开头的请求.
                .excludePathPatterns("/ding/login/auth");//放行登录接口
    }

    /**
     * 配置虚拟路径.浙政钉开发本地文件上传目录.打包时需注释
     * @param registry
     */
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/img/**").addResourceLocations("file:/D:/uploadPath/");
//        WebMvcConfigurer.super.addResourceHandlers(registry);
//    }
}
