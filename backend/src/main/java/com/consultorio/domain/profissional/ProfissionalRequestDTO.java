package com.consultorio.domain.profissional;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfissionalRequestDTO {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "CROSP é obrigatório")
    private String crosp;

    @NotBlank(message = "Endereço completo é obrigatório")
    private String enderecoCompleto;
}