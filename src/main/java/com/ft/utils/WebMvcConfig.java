package com.ft.utils;

import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //映射出static或templates中的文件夹，让不能直接访问的文件夹可以通过映射方式访问，后期完善
        registry.addResourceHandler("/image/**").addResourceLocations("file:D:/temp-rainy/");
    }


}
