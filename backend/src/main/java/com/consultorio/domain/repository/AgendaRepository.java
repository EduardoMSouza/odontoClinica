package com.consultorio.domain.repository;

import com.consultorio.domain.entity.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long> {

    @Query("SELECT COUNT(a) > 0 FROM Agenda a WHERE a.dentista.id = :dentistaId AND a.dataHora = :dataHora AND a.status != 'CANCELADO' AND a.id != :excludeId")
    boolean existsByDentistaIdAndDataHoraExcludingId(@Param("dentistaId") Long dentistaId,
                                                     @Param("dataHora") LocalDateTime dataHora,
                                                     @Param("excludeId") Long excludeId);

    @Query("SELECT COUNT(a) > 0 FROM Agenda a WHERE a.dentista.id = :dentistaId AND a.dataHora = :dataHora AND a.status != 'CANCELADO'")
    boolean existsByDentistaIdAndDataHora(@Param("dentistaId") Long dentistaId,
                                          @Param("dataHora") LocalDateTime dataHora);
}