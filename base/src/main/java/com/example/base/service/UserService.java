package com.example.base.service;

import com.example.base.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto save(UserDto userDto);
    List<UserDto> findByName(String name);
    boolean updateAddress(Long id, String newAddress);
}
