package com.consultorio.domain.agenda;

import com.consultorio.domain.paciente.Paciente;
import com.consultorio.domain.dentista.Dentista;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity @Table(name = "agendamentos")
@Getter @Setter @NoArgsConstructor
public class Agenda {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false) @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @ManyToOne(optional = false) @JoinColumn(name = "dentista_id")
    private Dentista dentista;

    @Column(nullable = false)
    private LocalDateTime dataHora;

    @Enumerated(EnumType.STRING) @Column(nullable = false)
    private StatusAgendamento status = StatusAgendamento.AGENDADO;

    @Column(length = 500)
    private String observacoes;
}
