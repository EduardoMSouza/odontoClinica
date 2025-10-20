package com.consultorio.domain.agenda.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter @Setter
public class AgendaRequestDTO {
    private Long pacienteId;
    private Long dentistaId;
    private LocalDateTime dataHora; // ISO-8601 no front
    private String observacoes;
}
