package com.example.demo.borisov2.config;

import com.example.demo.borisov2.aspect.CustomPointCut;
import com.example.demo.borisov2.aspect.ExceptionHandlerAspect;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@Configuration
@Import(MyBeanDefinitionRegistrar.class)
public class CovidConfiguration {
    @Bean
    public CustomPointCut customPointCut() {
        return new CustomPointCut();
    }
    @Bean
    public ExceptionHandlerAspect exceptionHandlerAspect() {
        return new ExceptionHandlerAspect();
    }

    @Bean
    public DefaultPointcutAdvisor defaultPointcutAdvisor() {
        return new DefaultPointcutAdvisor(customPointCut(), exceptionHandlerAspect());
    }
}
