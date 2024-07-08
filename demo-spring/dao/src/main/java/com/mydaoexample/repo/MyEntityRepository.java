package com.mydaoexample.repo;

import com.mydaoexample.model.MyEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MyEntityRepository extends CrudRepository<MyEntity, Long> {
    MyEntity findByName(String name);
    List<MyEntity> findAll();
    List<MyEntity> findBySubEntitiesNameContains(String name);
    List<MyEntity> findBySubEntitiesId(Long id);
}
