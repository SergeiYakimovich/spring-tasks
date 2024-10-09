package com.example.base.mapper;

import com.example.base.dao.UserEntity;
import com.example.base.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserDto toDto(UserEntity user);
    UserEntity toEntity(UserDto user);
    List<UserDto> toDtoList(List<UserEntity> users);
    List<UserEntity> toEntityList(List<UserDto> users);
}
