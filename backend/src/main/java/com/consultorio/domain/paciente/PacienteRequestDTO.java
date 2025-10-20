package com.consultorio.domain.paciente;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PacienteRequestDTO {
    private String nome;
    private String rg;
    private String cpf;
    private String dataNascimento;
    private String sexo;
    private String naturalidade;
    private String nacionalidade;
    private String estadoCivil;
    private String profissao;
    private String telefone;
    private String celular;
    private String email;
    private String enderecoResidencial;
    private String enderecoProfissional;
    private String indicadoPor;
    private String convenio;
    private String numeroInscricaoConvenio;
    private String cirurgiaoDentistaAnterior;
    private String dataAtendimentoAnterior;
    private String responsavelNome;
    private String responsavelRg;
    private String responsavelCpf;
    private String responsavelTelefone;
    private String responsavelCelular;
    private String responsavelEmail;
    private String responsavelEstadoCivil;
    private String conjugeNome;
    private String conjugeRg;
    private String conjugeCpf;
    private String conjugeTelefone;
    private String conjugeCelular;
    private String conjugeEmail;
}
