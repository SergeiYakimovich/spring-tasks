package com.example.base.service;

import com.example.base.dao.UserRepository;
import com.example.base.dao.UserEntity;
import com.example.base.dto.UserDto;
import com.example.base.mapper.UserMapper;
import jakarta.annotation.Nonnull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    public static final int SUCCESS_UPDATE_RESULT = 1;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    @Nonnull
    public UserDto save(@Nonnull UserDto userDto) {
        log.info("Saving user: {}", userDto);
        UserEntity userEntity = userMapper.toEntity(userDto);
        UserDto savedUser = Optional.of(userRepository.save(userEntity))
                .map(userMapper::toDto)
                .orElse(null);
        log.info("Saved user: {}", savedUser);
        return savedUser;
    }

    @Override
    @Nonnull
    public List<UserDto> findByName(@Nonnull String name) {
        log.info("Finding users by name: {}", name);
        List<UserEntity> userEntityList = userRepository.findByName(name);
        List<UserDto> userDtoList = userMapper.toDtoList(userEntityList);
        log.info("Found users: {}", userDtoList);
        return userDtoList;
    }

    @Override
    public boolean updateAddress(@Nonnull Long id, @Nonnull String newAddress) {
        log.info("Updating address for user with id: {}, new address: {}", id, newAddress);
        int result = userRepository.updateAddress(id, newAddress);
        log.info("Updating result: {}", result);
        return SUCCESS_UPDATE_RESULT == result;
    }
}
