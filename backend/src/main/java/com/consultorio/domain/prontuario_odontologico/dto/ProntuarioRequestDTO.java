package com.consultorio.domain.prontuario_odontologico.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProntuarioRequestDTO {
    private String numeroProntuario;
    private Long pacienteId;
    private Long profissionalId;
    private Long fichaMedicaId; // opcional: pode criar ficha depois
    private String opcaoTratamento;
    private String propositosOpcao1;
    private String riscosOpcao1;
    private String custosOpcao1;
    private String propositosOpcao2;
    private String riscosOpcao2;
    private String custosOpcao2;
    private String propositosOpcao3;
    private String riscosOpcao3;
    private String custosOpcao3;
    private String dataConsentimento;
    private String assinaturaPaciente;
    private String assinaturaProfissional;
}
