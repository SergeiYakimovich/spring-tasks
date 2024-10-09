package com.example.base.factory;

import com.example.base.dao.UserEntity;
import com.example.base.dto.UserDto;

public class UserFactory {
    public static UserDto getUserDto() {
        return UserDto.builder().name("Ivan").address("New York").build();
    }
    public static UserEntity getUserEntity() {
        UserEntity userEntity = new UserEntity();
        userEntity.setName("Ivan");
        userEntity.setAddress("New York");
        return userEntity;
    }
}
