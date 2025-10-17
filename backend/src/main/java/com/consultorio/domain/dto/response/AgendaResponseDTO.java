package com.consultorio.domain.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AgendaResponseDTO {
    private Long id;
    private String pacienteNome;
    private String dentistaNome;
    private String descricao;
    private String data; // yyyy-MM-dd
    private String hora; // HH:mm
    private String status;
    private Boolean cancelado;
}