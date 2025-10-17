package com.consultorio.domain.dto.response;

import com.consultorio.domain.entity.Paciente;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class PacienteResponseDTO {
    private Long id;
    private String cpf;
    private String numeroProntuario;
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
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAt;
    private ResponsavelResponseDTO responsavel;

    public PacienteResponseDTO(Paciente paciente) {
        this.id = paciente.getId();
        this.cpf = paciente.getCpf();
        this.numeroProntuario = paciente.getNumeroProntuario();
        this.nome = paciente.getNome();
        this.telefone = paciente.getTelefone();
        this.numeroRg = paciente.getNumeroRg();
        this.orgaoExpedidorRg = paciente.getOrgaoExpedidorRg();
        this.dataNascimento = paciente.getDataNascimento();
        this.sexo = paciente.getSexo();
        this.naturalidade = paciente.getNaturalidade();
        this.nacionalidade = paciente.getNacionalidade();
        this.estadoCivil = paciente.getEstadoCivil();
        this.profissao = paciente.getProfissao();
        this.enderecoResidencial = paciente.getEnderecoResidencial();
        this.indicadoPor = paciente.getIndicadoPor();
        this.convenio = paciente.getConvenio();
        this.numeroInscricao = paciente.getNumeroInscricao();
        this.dataCriacao = paciente.getDataCriacao();
        this.dataAt = paciente.getDataAt();

        if (paciente.getResponsavel() != null) {
            this.responsavel = new ResponsavelResponseDTO(paciente.getResponsavel());
        }
    }
}