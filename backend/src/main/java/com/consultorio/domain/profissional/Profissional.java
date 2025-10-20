package com.consultorio.domain.profissional;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Profissional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String crosp;

    @Column(nullable = false)
    private String enderecoCompleto;

    @Column(nullable = false, updatable = false)
    private LocalDateTime dataCadastro;

    @PrePersist
    protected void onCreate() {
        this.dataCadastro = LocalDateTime.now();
    }

    public Profissional() {}

    public Profissional(String nome, String crosp, String enderecoCompleto) {
        this.nome = nome;
        this.crosp = crosp;
        this.enderecoCompleto = enderecoCompleto;
    }
}