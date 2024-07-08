package com.mydaoexample.repo;

import com.mydaoexample.model.SubEntity;
import org.springframework.data.repository.CrudRepository;

public interface SubEntityRepository extends CrudRepository<SubEntity, Long> {
    SubEntity findByName(String name);
}
