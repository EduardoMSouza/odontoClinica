package com.consultorio.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
@Entity
@Getter
@Setter
@Table(name = "agendas")
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "dentista_id")
    private Dentista dentista;
    @ManyToOne(optional = false)
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;
    @Column(nullable = false)
    private LocalDateTime dataHora;
    @Column(nullable = false)
    private String descricao;
    @Column(nullable = false)
    private String status = "AGENDADO";
}






