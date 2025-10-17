package com.consultorio.domain.repository;

import com.consultorio.domain.entity.ResponsavelTratamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResponsavelRepository extends JpaRepository<ResponsavelTratamento, Long> {

    boolean existsByCpf(String cpf);
    Optional<ResponsavelTratamento> findByCpf(String cpf);
}