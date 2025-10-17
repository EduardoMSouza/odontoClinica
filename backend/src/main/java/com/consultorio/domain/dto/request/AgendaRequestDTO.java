package com.consultorio.domain.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AgendaRequestDTO {
    private Long pacienteId;
    private Long dentistaId;
    private String data; // yyyy-MM-dd
    private String hora; // HH:mm
    private String descricao;
}