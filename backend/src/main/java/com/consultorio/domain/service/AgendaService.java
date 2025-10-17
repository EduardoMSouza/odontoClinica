package com.consultorio.domain.service;

import com.consultorio.domain.dto.mapper.AgendaMapper;
import com.consultorio.domain.dto.request.AgendaRequestDTO;
import com.consultorio.domain.dto.response.AgendaResponseDTO;
import com.consultorio.domain.entity.Agenda;
import com.consultorio.domain.repository.AgendaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AgendaService {
    private final AgendaRepository repository;

    public AgendaService(AgendaRepository repository) {
        this.repository = repository;
    }

    public AgendaResponseDTO criar(AgendaRequestDTO dto) {
        Agenda agenda = AgendaMapper.toEntity(dto);
        validarDisponibilidade(agenda);
        Agenda saved = repository.save(agenda);
        return AgendaMapper.toDTO(saved);
    }

    public List<AgendaResponseDTO> listar() {
        return repository.findAll().stream()
                .map(AgendaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public AgendaResponseDTO buscarPorId(Long id) {
        Agenda agenda = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Agendamento não encontrado"));
        return AgendaMapper.toDTO(agenda);
    }

    public AgendaResponseDTO atualizar(Long id, AgendaRequestDTO dto) {
        Agenda agendaExistente = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Agendamento não encontrado"));

        // Atualizar dados
        Agenda agendaAtualizada = AgendaMapper.toEntity(dto);
        agendaAtualizada.setId(id);

        // Validar disponibilidade apenas se data/hora ou dentista mudaram
        if (!agendaExistente.getDataHora().equals(agendaAtualizada.getDataHora()) ||
                !agendaExistente.getDentista().getId().equals(agendaAtualizada.getDentista().getId())) {
            validarDisponibilidade(agendaAtualizada);
        }

        Agenda saved = repository.save(agendaAtualizada);
        return AgendaMapper.toDTO(saved);
    }

    public void cancelar(Long id) {
        Agenda agenda = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Agendamento não encontrado"));

        if ("CANCELADO".equals(agenda.getStatus())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Agendamento já está cancelado");
        }

        agenda.setStatus("CANCELADO");
        repository.save(agenda);
    }

    public void excluir(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Agendamento não encontrado");
        }
        repository.deleteById(id);
    }

    private void validarDisponibilidade(Agenda agenda) {
        boolean ocupado = repository.existsByDentistaIdAndDataHora(
                agenda.getDentista().getId(),
                agenda.getDataHora()
        );
        if (ocupado) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Horário já ocupado para este dentista!");
        }
    }
}