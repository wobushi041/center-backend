package org.wobushi041.centerbackend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



/**
 * 跨域配置
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //覆盖所有请求
        registry.addMapping("/**")
                //允许发送Cookie
                .allowCredentials(true)
                //允许放行的域名（必须是patterns，否则*会与allowCredentials冲突）
                .allowedOriginPatterns("*")
                //设置允许的方法
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                //跨域允许时间
                .maxAge(3600);
    }
}
