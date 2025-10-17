package com.consultorio.domain.repository;

import com.consultorio.domain.entity.FichaMedica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FichaMedicaRepository extends JpaRepository<FichaMedica, Long> {

    List<FichaMedica> findByPacienteId(Long pacienteId);

    @Query("SELECT fm FROM FichaMedica fm WHERE fm.paciente.nome LIKE %:nomePaciente%")
    List<FichaMedica> findByPacienteNomeContaining(@Param("nomePaciente") String nomePaciente);

    boolean existsByPacienteId(Long pacienteId);

    @Query("SELECT COUNT(fm) FROM FichaMedica fm WHERE fm.paciente.id = :pacienteId")
    long countByPacienteId(@Param("pacienteId") Long pacienteId);
}