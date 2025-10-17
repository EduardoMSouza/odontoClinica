package com.consultorio.domain.repository;

import com.consultorio.domain.entity.Dentista;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DentistaRepository extends JpaRepository<Dentista, Long> {
    boolean existsByCro(String cro);
}