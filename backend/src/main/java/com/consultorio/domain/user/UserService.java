package com.consultorio.domain.user;

import com.consultorio.domain.user.dto.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    public UserService(UserRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional
    public UserResponseDto criar(UserRequestDto dto) {
        User user = mapper.toEntity(dto);
        return mapper.toResponseDto(repository.save(user));
    }

    public List<UserResponseDto> listar() {
        return mapper.toResponseDtoList(repository.findAll());
    }

    public UserResponseDto buscarPorId(Long id) {
        return repository.findById(id)
                .map(mapper::toResponseDto)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    @Transactional
    public UserResponseDto atualizar(Long id, UserRequestDto dto) {
        User user = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        mapper.updateFromDto(dto, user);
        return mapper.toResponseDto(repository.save(user));
    }

    @Transactional
    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Usuário não encontrado");
        }
        repository.deleteById(id);
    }
}
