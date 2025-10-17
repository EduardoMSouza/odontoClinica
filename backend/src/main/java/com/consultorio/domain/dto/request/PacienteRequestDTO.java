package com.consultorio.domain.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PacienteRequestDTO {

    @NotBlank(message = "CPF é obrigatório")
    private String cpf;

    @NotBlank(message = "Número do prontuário é obrigatório")
    private String numeroProntuario;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    private String telefone;
    private String numeroRg;
    private String orgaoExpedidorRg;
    private String dataNascimento;
    private String sexo;
    private String naturalidade;
    private String nacionalidade;
    private String estadoCivil;
    private String profissao;
    private String enderecoResidencial;
    private String indicadoPor;
    private String convenio;
    private String numeroInscricao;

    // Dados do responsável
    private ResponsavelRequestDTO responsavel;
}