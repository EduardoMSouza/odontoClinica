package com.consultorio.domain.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponsavelRequestDTO {
    private String nome;
    private String numeroRg;
    private String orgaoExpedidor;
    private String cpf;
    private String estadoCivil;
    private String conjuge;
    private String numeroRgConjuge;
    private String orgaoExpedidorConjuge;
    private String cpfConjuge;
}