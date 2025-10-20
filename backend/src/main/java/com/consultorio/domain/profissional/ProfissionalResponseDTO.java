package com.consultorio.domain.profissional;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfissionalResponseDTO {

    private Long id;
    private String nome;
    private String crosp;
    private String enderecoCompleto;
    private String dataCadastro;

    public ProfissionalResponseDTO(Profissional profissional) {
        this.id = profissional.getId();
        this.nome = profissional.getNome();
        this.crosp = profissional.getCrosp();
        this.enderecoCompleto = profissional.getEnderecoCompleto();
        this.dataCadastro = String.valueOf(profissional.getDataCadastro());
    }
}