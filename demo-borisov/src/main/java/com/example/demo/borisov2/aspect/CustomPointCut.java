package com.example.demo.borisov2.aspect;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;

public class CustomPointCut extends DynamicMethodMatcherPointcut {
    private String packages = "com.example.demo.borisov2";
    @Override
    public boolean matches(Method method, Class<?> targetClass, Object... args) {
        return true;
    }

    @Override
    public ClassFilter getClassFilter() {
        return new ClassFilter() {
            @Override
            public boolean matches(Class<?> aClazz) {
                return aClazz.getPackage().getName().startsWith(packages);
            }
        };
    }
}
