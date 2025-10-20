package com.consultorio.domain.agenda.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter @AllArgsConstructor
public class AgendaResponseDTO {
    private Long id;
    private Long pacienteId;
    private String pacienteNome;
    private Long dentistaId;
    private String dentistaNome;
    private LocalDateTime dataHora;
    private String status;
    private String observacoes;
}
