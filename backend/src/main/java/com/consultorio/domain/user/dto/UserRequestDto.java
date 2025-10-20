package com.consultorio.domain.user.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * DTO usado para receber dados do frontend.
 * Todas as validações são feitas no frontend.
 */
@Getter
@Setter
public class UserRequestDto {
    private String nome;
    private String email;
    private String senha;
    private String cargo;
    private Boolean ativo;
}
