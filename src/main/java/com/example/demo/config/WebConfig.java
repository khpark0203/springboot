package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.interceptor.LogInterceptor;
import com.example.demo.interceptor.ShoutInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LogInterceptor())
				.addPathPatterns("/family/**");

		registry.addInterceptor(new ShoutInterceptor())
				.addPathPatterns("/family/**");
	}
}
