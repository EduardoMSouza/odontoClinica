package com.consultorio.domain.agenda.dto;

import com.consultorio.domain.agenda.Agenda;

public class AgendaMapper {

    public static AgendaResponseDTO toResponse(Agenda a){
        return new AgendaResponseDTO(
                a.getId(),
                a.getPaciente().getId(),
                a.getPaciente().getNome(),
                a.getDentista().getId(),
                a.getDentista().getNome(),
                a.getDataHora(),
                a.getStatus().name(),
                a.getObservacoes()
        );
    }
}
