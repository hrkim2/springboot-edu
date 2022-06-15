package com.example.springedu.comm.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.springedu.comm.interceptor.SomeInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(getSomeInterceptor())
		.addPathPatterns("/**")
		.excludePathPatterns("/js/**", "/css/**", "/img/**", "/favicon.ico", "/error");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry){
		registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/").setCachePeriod(60 * 60 * 24 * 365);
		registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/").setCachePeriod(60 * 60 * 24 * 365);
		registry.addResourceHandler("/img/**").addResourceLocations("classpath:/static/img/").setCachePeriod(60 * 60 * 24 * 365);
	}
	
	@Bean
	public SomeInterceptor getSomeInterceptor() {
		return new SomeInterceptor();
	}
}
