package com.consultorio.domain.agenda;

import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {
    List<Agenda> findByDentistaIdAndDataHoraBetween(Long dentistaId, LocalDateTime inicio, LocalDateTime fim);
    List<Agenda> findByPacienteId(Long pacienteId);
}
