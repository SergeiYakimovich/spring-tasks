package com.mydaoexample;

import com.mydaoexample.model.MyEntity;
import com.mydaoexample.model.SubEntity;
import com.mydaoexample.repo.MyEntityRepository;
import com.mydaoexample.repo.SubEntityRepository;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jmx.StatisticsService;
import org.hibernate.stat.Statistics;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static com.mydaoexample.bpp.ProfilingSQLAnnotationPostProcessor.showSQLStatistics;

//@SpringBootTest // весь контекст
@DataJpaTest // только бины-репозитории создает
@TestPropertySource("classpath:application-test.properties")
@AutoConfigureTestDatabase
@Transactional(propagation = Propagation.NOT_SUPPORTED)
class MyEntityRepositoryTest {
    @Autowired
    private MyEntityRepository myEntityRepository;
    @Autowired
    private SubEntityRepository subEntityRepository;
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private EntityManager entityManager;

    final Random random = new Random();

    @Test
    void statisticTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        testWithStatistic(this.getClass().getDeclaredMethod("fetchTest"));
    }

    @Test
    void findTest() {
        createMyEntity(createSubEntityList(1));
        createMyEntity(createSubEntityList(1));

        List<MyEntity> result = myEntityRepository.findBySubEntitiesNameContains("Имя");
        System.out.println("\n!!!!!!!!!" + result);

        result = myEntityRepository.findBySubEntitiesId(1L);
        System.out.println("\n!!!!!!!!!" + result);
    }

    @Test
    void easyRandomTest() {
        EasyRandomParameters parameters = new EasyRandomParameters().excludeField(field -> field.getName().equals("id"));
        parameters.collectionSizeRange(1,3).setStringLengthRange(new EasyRandomParameters.Range<>(3,4));
        EasyRandom easyRandom = new EasyRandom(parameters);
        MyEntity myEntity = easyRandom.nextObject(MyEntity.class);
        System.out.println(myEntity);
        myEntity = easyRandom.nextObject(MyEntity.class);
        System.out.println(myEntity);
    }

    @Test
    void fetchTest() {
        createMyEntity(createSubEntityList(3));

        List<MyEntity> result = myEntityRepository.findAll();
        System.out.println("\n!!!!!!!!!" + result);

    }

    @Test
    void softDeleteTest() {
        createMyEntity(null);
        createMyEntity(null);
        List<MyEntity> result = myEntityRepository.findAll();
        System.out.println("\n!!!!!!!!!" + result);

        myEntityRepository.delete(result.get(0));
        result = myEntityRepository.findAll();
        System.out.println("\n!!!!!!!!!" + result);
    }

    void testWithStatistic(Method method) throws InvocationTargetException, IllegalAccessException {
        StatisticsService statisticsService = new StatisticsService();
        statisticsService.setSessionFactory(sessionFactory);

        method.invoke(this);

        showSQLStatistics(statisticsService);
    }

    @Test
    void testWithStatistic_v2() {
//        Session session = entityManager.unwrap(Session.class);
//        Statistics statistics = session.getSessionFactory().getStatistics();
        Statistics statistics = sessionFactory.getStatistics();

        createMyEntity(null);
        var result = myEntityRepository.findAll();
        System.out.println(result);

        showSQLStatistics(statistics);
    }

    private void createMyEntity(List<SubEntity> subEntities) {
        myEntityRepository.save(MyEntity.builder().name("Name-" + random.nextInt(100))
                .subEntities(subEntities)
                .active(true)
                .build());
    }

    private List<SubEntity> createSubEntityList(int n) {
        List<SubEntity> subEntities = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            subEntities.add(SubEntity.builder().name("Имя-" + random.nextInt(1000)).build());
        }
//        subEntityRepository.saveAll(subEntities);
        return subEntities;
    }

}