package com.example.demo.borisov3;

import com.example.demo.borisov3.genre.Action;
import com.example.demo.borisov3.genre.AnyGenre;
import com.example.demo.borisov3.genre.Comedy;
import com.example.demo.borisov3.genre.Melodrama;
import lombok.SneakyThrows;
import org.reflections.ReflectionUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.beans.Introspector;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class ActorsBPP implements BeanPostProcessor {
    @Autowired
    private ApplicationContext context;
    private final Set<Class<? extends Annotation>> GENRES = Set.of(Action.class, Comedy.class, Melodrama.class);
    Map<String, List<Class>> map = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        List<Class<? extends Annotation>> genresList = getGenres(beanClass);
        for (Class<? extends Annotation> genre : genresList) {
            String genreName = Introspector.decapitalize(genre.getSimpleName());
            System.out.println("Добавляем "+ beanName + " " + genreName);
            if (map.containsKey(genreName)) {
                map.get(genreName).add(beanClass);
            } else {
                List<Class> list = new ArrayList<>();
                list.add(beanClass);
                map.put(genreName, list);
            }
        }
        return bean;
    }

    @SneakyThrows
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        Set<Field> fields = ReflectionUtils.getAllFields(bean.getClass(), this::isGenrePresent);
        for (Field field : fields) {
            Set<Object> allBeansSet = new HashSet<>();
            List<Class<? extends Annotation>> genresList = getGenres(field);
            for (Class<? extends Annotation> genre : genresList) {
                String genreName = Introspector.decapitalize(genre.getSimpleName());
                Set<Object> genreBeansSet = map.get(genreName).stream()
                        .map(aClass -> Introspector.decapitalize(aClass.getSimpleName()))
                        .map(name -> context.getBean(name))
                        .collect(Collectors.toSet());
                allBeansSet.addAll(genreBeansSet);
            }
            field.setAccessible(true);
            field.set(bean, allBeansSet.stream().toList());
        }
        return bean;
    }

    private boolean isGenrePresent(Field field) {
        for (Class<? extends Annotation> genre : GENRES) {
            if(field.isAnnotationPresent(genre)) {
                return true;
            }
        }
        return false;
    }

    private List<Class<? extends Annotation>> getGenres(Class<?> beanClass) {
        List<Class<? extends Annotation>> genresList = new ArrayList<>();
        Annotation[] annotations = beanClass.getAnnotations();
        List<Annotation> allAnnotations = new ArrayList<>(Arrays.asList(annotations));
        for (Annotation annotation : annotations) {
            allAnnotations.addAll(Arrays.stream(annotation.annotationType().getAnnotations()).toList());
        }
        for (Annotation annotation : allAnnotations) {
            if (GENRES.contains(annotation.annotationType())) {
                genresList.add(annotation.annotationType());
            }
        }
        return genresList;
    }

    private List<Class<? extends Annotation>> getGenres(Field field) {
        List<Class<? extends Annotation>> genresList = new ArrayList<>();
        Annotation[] annotations = field.getAnnotations();
        for (Annotation annotation : annotations) {
            if (GENRES.contains(annotation.annotationType())) {
                genresList.add(annotation.annotationType());
            }
        }
        return genresList;
    }
}
