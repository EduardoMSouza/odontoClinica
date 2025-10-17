package com.consultorio.domain.dto.response;

import com.consultorio.domain.entity.ResponsavelTratamento;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponsavelResponseDTO {
    private Long id;
    private String nome;
    private String numeroRg;
    private String orgaoExpedidor;
    private String cpf;
    private String estadoCivil;
    private String conjuge;
    private String numeroRgConjuge;
    private String orgaoExpedidorConjuge;
    private String cpfConjuge;

    public ResponsavelResponseDTO(ResponsavelTratamento responsavel) {
        this.id = responsavel.getId();
        this.nome = responsavel.getNome();
        this.numeroRg = responsavel.getNumeroRg();
        this.orgaoExpedidor = responsavel.getOrgaoExpedidor();
        this.cpf = responsavel.getCpf();
        this.estadoCivil = responsavel.getEstadoCivil();
        this.conjuge = responsavel.getConjuge();
        this.numeroRgConjuge = responsavel.getNumeroRgConjuge();
        this.orgaoExpedidorConjuge = responsavel.getOrgaoExpedidorConjuge();
        this.cpfConjuge = responsavel.getCpfConjuge();
    }
}