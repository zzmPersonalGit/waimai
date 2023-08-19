package com.example.waimaideliver.config;

import com.example.waimaideliver.common.intercerper.LoginIntercepter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class LoginConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new LoginIntercepter())
                /*需要拦截的请求*/
                .addPathPatterns("/**")
                /*需要放行的请求*/
                .excludePathPatterns("/","/login-deliver","/error","/register","/deliver/feign","/test/format","/login-username-deliver");

    }
}
