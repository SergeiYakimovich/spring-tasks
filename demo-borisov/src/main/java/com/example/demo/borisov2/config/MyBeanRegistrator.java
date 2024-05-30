package com.example.demo.borisov2.config;

import com.example.demo.borisov2.config.CCL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.AutowireCandidateQualifier;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class MyBeanRegistrator {
    @Autowired
    private GenericApplicationContext context;
    @Autowired
    private CCL classLoader;

    public void registerBean(String beanName, String className) {
        Class<?> beanClass = classLoader.findClass(className);
        BeanDefinitionRegistry beanFactory = (BeanDefinitionRegistry) context.getBeanFactory();
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setScope(GenericBeanDefinition.SCOPE_SINGLETON);
        beanDefinition.setBeanClass(beanClass);
        beanFactory.registerBeanDefinition(beanName, beanDefinition);
        context.getBean(beanName);
        System.out.println("Registered bean " + beanName);
    }
}
