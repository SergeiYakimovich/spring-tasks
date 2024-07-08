package com.mydaoexample.bpp;

import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.hibernate.stat.Statistics;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class ProfilingSQLAnnotationPostProcessor implements BeanPostProcessor {
    private final ApplicationContext context;
    Map<String, Class> beanMap = new HashMap<>();
    Map<String, Method> methodMap = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        if (hasAnnotatedMethods(beanClass)) {
            System.out.println("\n!!! ProfilingSQLAnnotationPostProcessor - Добавляем ProfilingSQL для " + beanName + "\n");
            beanMap.put(beanName, beanClass);
        }
        return bean;
    }

    private boolean hasAnnotatedMethods(Class<?> beanClass) {
        boolean annotated = false;
        Method[] methods = beanClass.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(ProfilingSQL.class)) {
                methodMap.put(method.getName(), method);
                annotated = true;
            }
        }
         return annotated;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class beanClass = beanMap.get(beanName);
        if (beanClass != null) {
            return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    if (methodMap.containsKey(method.getName())) {
                        System.out.println("\n!!! ProfilingSQLAnnotationPostProcessor - Профилирую " + beanName + " - " + method.getName() + "\n");
                        SessionFactory sessionFactory = context.getBean(SessionFactory.class);
                        Statistics statistics = sessionFactory.getStatistics();
                        statistics.clear();
                        Object result = method.invoke(bean, args);
                        showSQLStatistics(statistics);
                        return result;
                    } else {
                        return method.invoke(bean, args);
                    }
                }
            });
        }
        return bean;
    }



    public static void showSQLStatistics(Statistics statisticsService) {
        System.out.println("\n____________________________________________________________________________");
        System.out.println("ConnectCount = " + statisticsService.getConnectCount());
        System.out.println("TransactionCount = " + statisticsService.getSuccessfulTransactionCount());
        System.out.println("PrepareStatementCount = " + statisticsService.getPrepareStatementCount());
        System.out.println("QueryExecutionCount = " + statisticsService.getQueryExecutionCount());
        System.out.println("Queries = " + Arrays.toString(statisticsService.getQueries()));
        System.out.println("EntityNames = " + Arrays.toString(statisticsService.getEntityNames()));
        System.out.println("EntityStatistics = " + statisticsService.getEntityStatistics("com.mydaoexample.model.MyEntity"));
        System.out.println("SubEntityStatistics = " + statisticsService.getEntityStatistics("com.mydaoexample.model.SubEntity"));
        System.out.println("____________________________________________________________________________\n");
    }
}
