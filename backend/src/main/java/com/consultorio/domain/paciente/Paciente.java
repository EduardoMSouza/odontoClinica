package com.consultorio.domain.paciente;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "pacientes")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column
    private String rg;

    @Column
    private String cpf;

    @Column
    private String dataNascimento;

    @Column
    private String sexo;

    @Column
    private String naturalidade;

    @Column
    private String nacionalidade;

    @Column
    private String estadoCivil;

    @Column
    private String profissao;

    @Column
    private String telefone;

    @Column
    private String celular;

    @Column
    private String email;

    @Column
    private String enderecoResidencial;

    @Column
    private String enderecoProfissional;

    @Column
    private String indicadoPor;

    @Column
    private String convenio;

    @Column
    private String numeroInscricaoConvenio;

    @Column
    private String cirurgiaoDentistaAnterior;

    @Column
    private String dataAtendimentoAnterior;

    // Responsável pelo Tratamento
    @Column
    private String responsavelNome;

    @Column
    private String responsavelRg;

    @Column
    private String responsavelCpf;

    @Column
    private String responsavelTelefone;

    @Column
    private String responsavelCelular;

    @Column
    private String responsavelEmail;

    @Column
    private String responsavelEstadoCivil;

    @Column
    private String conjugeNome;

    @Column
    private String conjugeRg;

    @Column
    private String conjugeCpf;

    @Column
    private String conjugeTelefone;

    @Column
    private String conjugeCelular;

    @Column
    private String conjugeEmail;

    public Paciente() {}

    public Paciente(String nome, String cpf, String dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }
}
