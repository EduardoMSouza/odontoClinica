package com.consultorio.domain.agenda;

import com.consultorio.domain.agenda.dto.*;
import com.consultorio.domain.dentista.Dentista;
import com.consultorio.domain.dentista.DentistaRepository;
import com.consultorio.domain.paciente.Paciente;
import com.consultorio.domain.paciente.PacienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AgendaService {

    private final AgendaRepository repo;
    private final PacienteRepository pacienteRepo;
    private final DentistaRepository dentistaRepo;

    public AgendaService(AgendaRepository repo, PacienteRepository pacienteRepo, DentistaRepository dentistaRepo) {
        this.repo = repo;
        this.pacienteRepo = pacienteRepo;
        this.dentistaRepo = dentistaRepo;
    }

    @Transactional
    public AgendaResponseDTO agendar(AgendaRequestDTO dto){
        Paciente p = pacienteRepo.findById(dto.getPacienteId())
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
        Dentista d = dentistaRepo.findById(dto.getDentistaId())
                .orElseThrow(() -> new RuntimeException("Dentista não encontrado"));

        Agenda a = new Agenda();
        a.setPaciente(p);
        a.setDentista(d);
        a.setDataHora(dto.getDataHora());
        a.setObservacoes(dto.getObservacoes());
        a.setStatus(StatusAgendamento.AGENDADO);

        return AgendaMapper.toResponse(repo.save(a));
    }

    public List<AgendaResponseDTO> listar(){
        return repo.findAll().stream().map(AgendaMapper::toResponse).toList();
    }

    public AgendaResponseDTO buscar(Long id){
        Agenda a = repo.findById(id).orElseThrow(() -> new RuntimeException("Agendamento não encontrado"));
        return AgendaMapper.toResponse(a);
    }

    @Transactional
    public AgendaResponseDTO atualizarStatus(Long id, String status){
        Agenda a = repo.findById(id).orElseThrow(() -> new RuntimeException("Agendamento não encontrado"));
        a.setStatus(StatusAgendamento.valueOf(status.toUpperCase()));
        return AgendaMapper.toResponse(repo.save(a));
    }

    @Transactional
    public void cancelar(Long id){
        Agenda a = repo.findById(id).orElseThrow(() -> new RuntimeException("Agendamento não encontrado"));
        a.setStatus(StatusAgendamento.CANCELADO);
        repo.save(a);
    }

    @Transactional
    public void deletar(Long id){
        if(!repo.existsById(id)) throw new RuntimeException("Agendamento não encontrado");
        repo.deleteById(id);
    }
}
