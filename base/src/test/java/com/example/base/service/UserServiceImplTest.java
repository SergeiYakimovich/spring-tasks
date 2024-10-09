package com.example.base.service;

import com.example.base.dao.UserRepository;
import com.example.base.dto.UserDto;
import com.example.base.factory.UserFactory;
import com.example.base.mapper.UserMapperImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    @Spy
    private UserMapperImpl userMapper;
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void save() {
        // given
        UserDto userDto = UserFactory.getUserDto();
        when(userRepository.save(any())).thenReturn(UserFactory.getUserEntity());

        // when
        UserDto result = userService.save(userDto);

        // then
        assertThat(userDto).usingRecursiveAssertion().isEqualTo(result);
    }
}