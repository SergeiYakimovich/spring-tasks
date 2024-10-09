package com.example.base.dao;

import com.example.base.factory.UserFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @BeforeEach
    void setUp() {
        userRepository.deleteAll();
    }

    @Test
    void testRepository() {
        userRepository.save(UserFactory.getUserEntity());
        List<UserEntity> all = userRepository.findAll();

        assertEquals(1, all.size());
        assertEquals("Ivan", all.get(0).getName());
        assertEquals("New York", all.get(0).getAddress());
    }

    @Test
    void updateAddress() {
        UserEntity savedEntity = userRepository.save(UserFactory.getUserEntity());
        int result = userRepository.updateAddress(savedEntity.getId(), "London");
        UserEntity updatedEntity = userRepository.findAll().get(0);

        assertEquals(1, result);
        assertEquals("London", updatedEntity.getAddress());
    }

    @Test
    void findByName() {
        UserEntity savedEntity = userRepository.save(UserFactory.getUserEntity());
        UserEntity foundEntity = userRepository.findByName("va").get(0);

        assertThat(savedEntity).usingRecursiveComparison().isEqualTo(foundEntity);
    }
}