package com.consultorio.domain.prontuario_odontologico.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class ProntuarioResponseDTO {
    private Long id;
    private String numeroProntuario;
    private Long pacienteId;
    private String pacienteNome;
    private Long profissionalId;
    private String profissionalNome;
    private Long fichaMedicaId;
    private String opcaoTratamento;
}
