package com.consultorio.domain.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DentistaResponseDTO {
    private Long id;
    private String nome;
    private String cro;
    private String especialidade;
    private String telefone;
    private String email;
    private Boolean ativo;
}
