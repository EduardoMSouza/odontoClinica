package com.consultorio.domain.user.dto;

import com.consultorio.domain.user.User;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

/**
 * Mapper para conversão entre User e DTOs.
 */
@Mapper(componentModel = "spring")
public abstract class UserMapper {

    @Autowired
    protected PasswordEncoder passwordEncoder;

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "senha", expression = "java(encodePassword(dto.getSenha()))")
    public abstract User toEntity(UserRequestDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "senha", ignore = true)
    public abstract void updateFromDto(UserRequestDto dto, @MappingTarget User entity);

    public abstract UserResponseDto toResponseDto(User entity);
    public abstract List<UserResponseDto> toResponseDtoList(List<User> entities);

    protected String encodePassword(String senha) {
        if (senha == null || senha.trim().isEmpty()) return null;
        return passwordEncoder.encode(senha);
    }
}
