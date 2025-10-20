package com.consultorio.domain.ficha_medica;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FichaMedicaRepository extends JpaRepository<FichaMedica, Long> {

    @Query("SELECT fm FROM FichaMedica fm WHERE fm.paciente.id = :pacienteId ORDER BY fm.dataCriacao DESC")
    List<FichaMedica> findByPacienteId(@Param("pacienteId") Long pacienteId);

    @Query("SELECT fm FROM FichaMedica fm JOIN FETCH fm.paciente WHERE fm.id = :id")
    Optional<FichaMedica> findByIdWithPaciente(@Param("id") Long id);

    boolean existsByPacienteId(Long pacienteId);

    long countByPacienteId(Long pacienteId);
}