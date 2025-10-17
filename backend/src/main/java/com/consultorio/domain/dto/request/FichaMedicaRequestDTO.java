package com.consultorio.domain.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FichaMedicaRequestDTO {

    @NotNull(message = "Paciente é obrigatório")
    private Long pacienteId;

    // Dados de saúde geral
    private Boolean problemasRespiratorios;
    private Boolean problemasAlergicos;
    private Boolean problemasArticulares;
    private Boolean diabetes;

    // Questionário de Saúde
    private Boolean sofreDoenca;
    private List<String> quaisDoencas;
    private Boolean emTratamentoMedico;
    private Boolean gravidez;
    private Boolean usandoMedicacao;
    private List<String> quaisMedicamentos;
    private String nomeMedicoAssistente;
    private String telefoneMedicoAssistente;
    private Boolean teveAlergia;
    private List<String> quaisAlergias;
    private Boolean jaOperado;
    private List<String> quaisCirurgias;
    private Boolean problemasCicatrizacao;
    private Boolean problemasAnestesia;
    private Boolean problemasHemorragia;

    // Outras informações
    private String queixaPrincipal;
    private String habitos;
    private List<String> antecedentesFamiliares;

    // Inspeção da boca e da face
    private String lingua;
    private String mucosa;
    private String palato;
    private String face;
    private String labios;
    private Boolean alteracaoOclusao;
    private String tipoAlteracaoOclusao;
    private Boolean usaProtese;
    private String tipoProtese;
    private String gengivas;
    private String nariz;
    private String ganglios;
    private String glandulasSalivares;
    private String outrasObservacoes;
}