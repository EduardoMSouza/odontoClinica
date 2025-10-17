package com.consultorio.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "responsaveis_tratamento")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponsavelTratamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String numeroRg;
    private String orgaoExpedidor;
    private String cpf;
    private String estadoCivil;

    // Dados do cônjuge
    private String conjuge;
    private String numeroRgConjuge;
    private String orgaoExpedidorConjuge;
    private String cpfConjuge;

    // Relacionamento bidirecional opcional
    @OneToOne(mappedBy = "responsavel")
    private Paciente paciente;
}