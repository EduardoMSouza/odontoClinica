package com.consultorio.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "pacientes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 14)
    private String cpf;

    @Column(nullable = false, unique = true, length = 20)
    private String numeroProntuario;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(length = 20)
    private String telefone;

    @Column(name = "numero_rg", length = 20)
    private String numeroRg;

    @Column(name = "orgao_expedidor_rg", length = 50)
    private String orgaoExpedidorRg;

    @Column(name = "data_nascimento", length = 10)
    private String dataNascimento;

    @Column(length = 15)
    private String sexo;

    @Column(length = 50)
    private String naturalidade;

    @Column(length = 50)
    private String nacionalidade;

    @Column(name = "estado_civil", length = 20)
    private String estadoCivil;

    @Column(length = 50)
    private String profissao;

    @Column(name = "endereco_residencial", length = 200)
    private String enderecoResidencial;

    @Column(name = "indicado_por", length = 100)
    private String indicadoPor;

    @Column(length = 50)
    private String convenio;

    @Column(name = "numero_inscricao", length = 50)
    private String numeroInscricao;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "responsavel_id")
    private ResponsavelTratamento responsavel;

    @Column(name = "data_criacao", nullable = false)
    private LocalDateTime dataCriacao;

    @Column(name = "data_atualizacao")
    private LocalDateTime dataAt;

    @PrePersist
    protected void onCreate() {
        this.dataCriacao = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.dataAt = LocalDateTime.now();
    }
}