package com.consultorio.domain.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DentistaRequestDTO {

    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @NotBlank(message = "O CRO é obrigatório")
    private String cro;

    private String especialidade;

    private String telefone;

    @Email(message = "E-mail inválido")
    private String email;
}
