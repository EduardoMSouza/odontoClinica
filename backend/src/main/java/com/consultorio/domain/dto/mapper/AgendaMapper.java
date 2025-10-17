package com.consultorio.domain.dto.mapper;

import com.consultorio.domain.dto.request.AgendaRequestDTO;
import com.consultorio.domain.dto.response.AgendaResponseDTO;
import com.consultorio.domain.entity.Agenda;
import com.consultorio.domain.entity.Dentista;
import com.consultorio.domain.entity.Paciente;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AgendaMapper {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

    public static Agenda toEntity(AgendaRequestDTO dto) {
        Agenda agenda = new Agenda();
        agenda.setDescricao(dto.getDescricao());

        // Combinar data e hora
        if (dto.getData() != null && dto.getHora() != null) {
            LocalDateTime dataHora = LocalDateTime.parse(
                    dto.getData() + "T" + dto.getHora(),
                    DATE_TIME_FORMATTER
            );
            agenda.setDataHora(dataHora);
        }

        // Set relations with IDs
        if (dto.getPacienteId() != null) {
            Paciente paciente = new Paciente();
            paciente.setId(dto.getPacienteId());
            agenda.setPaciente(paciente);
        }
        if (dto.getDentistaId() != null) {
            Dentista dentista = new Dentista();
            dentista.setId(dto.getDentistaId());
            agenda.setDentista(dentista);
        }

        agenda.setStatus("AGENDADO");
        return agenda;
    }

    public static AgendaResponseDTO toDTO(Agenda agenda) {
        AgendaResponseDTO dto = new AgendaResponseDTO();
        dto.setId(agenda.getId());
        dto.setPacienteNome(agenda.getPaciente().getNome());
        dto.setDentistaNome(agenda.getDentista().getNome());
        dto.setDescricao(agenda.getDescricao());
        dto.setStatus(agenda.getStatus());
        dto.setCancelado("CANCELADO".equals(agenda.getStatus()));

        // Separar data e hora para o frontend
        if (agenda.getDataHora() != null) {
            dto.setData(agenda.getDataHora().format(DATE_FORMATTER));
            dto.setHora(agenda.getDataHora().format(TIME_FORMATTER));
        }

        return dto;
    }
}