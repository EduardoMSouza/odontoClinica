package com.consultorio.domain.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FichaAnamnese {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Anamnes
    private boolean tomandoMedicamento;

    @Column(length = 500)
    private String medicamentosPosologia;
    private boolean temAlergia;
    private String tipoAlergia;

    @Enumerated(EnumType.STRING)
    @Column
    private PressaoArterial pressao;
    private boolean problemaCardiaco;
    private String tipoProblemaCardiaco;
    private boolean faltaAr;
    private boolean diabetes;

    @Enumerated(EnumType.STRING)
    @Column
    private Sangramento sangramento;

    @Enumerated(EnumType.STRING)
    @Column
    private Cicatrizacao cicatrizacao;
    private boolean cirurgia;
    private boolean gestante;

    private Integer semanasGestacao;

    @Column(length = 500)
    private String problemasSaude;

    @Column(length = 500, nullable = false)
    private String queixaPrincipal;
    private boolean reacaoAnestesia;
    private String tipoReacaoAnestesia;
    private String ultimoTratamentoDentario;
    private boolean dorDentesGengiva;
    private boolean gengivaSangra;
    private boolean gengivaSangraHigiene;
    private boolean gengivaSangraAsVezes;
    private boolean gostoRuimBocaSeca;
    private Integer escovacaoDiaria;
    private boolean usaFioDental;
    private boolean usaFioDentalDiariamente;
    private boolean dorEstaloMaxilarOuvido;
    private boolean rangeDentes;
    private boolean feridaBolhaFaceLabios;
    private boolean fuma;
    private String quantidadeFumo;



    // Data de criação
    @Column(nullable = false)
    private LocalDateTime dataCriacao;

    // Relacionamento com Paciente
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;
}








