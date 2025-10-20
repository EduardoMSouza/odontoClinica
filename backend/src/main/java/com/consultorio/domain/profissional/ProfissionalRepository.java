package com.consultorio.domain.profissional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfissionalRepository
        extends JpaRepository<Profissional, Long> {

    boolean existsByCrosp(String crosp);

    boolean existsByNome(String nome);

    Profissional findByNome(String nome);
}
