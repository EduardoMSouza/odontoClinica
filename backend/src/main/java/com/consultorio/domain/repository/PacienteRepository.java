package com.consultorio.domain.repository;

import com.consultorio.domain.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    boolean existsByCpf(String cpf);
    boolean existsByNumeroProntuario(String numeroProntuario);

    Optional<Paciente> findByCpf(String cpf);
    Optional<Paciente> findByNumeroProntuario(String numeroProntuario);

    List<Paciente> findByNomeContainingIgnoreCase(String nome);

    @Query("SELECT p FROM Paciente p WHERE p.responsavel.id = :responsavelId")
    List<Paciente> findByResponsavelId(@Param("responsavelId") Long responsavelId);
}