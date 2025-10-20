package com.consultorio.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO usado para retornar dados ao frontend.
 */
@Getter
@Setter
@AllArgsConstructor
public class UserResponseDto {
    private Long id;
    private String nome;
    private String email;
    private String cargo;
    private Boolean ativo;
}
