package com.consultorio.domain.dto.response;

import com.consultorio.domain.entity.FichaMedica;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class FichaMedicaResponseDTO {
    private Long id;
    private LocalDateTime dataCriacao;

    // Dados do paciente
    private Long pacienteId;
    private String pacienteNome;
    private String pacienteCpf;

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

    private LocalDateTime dataAssinatura;
    private String assinaturaPaciente;

    public FichaMedicaResponseDTO(FichaMedica fichaMedica) {
        this.id = fichaMedica.getId();
        this.dataCriacao = fichaMedica.getDataCriacao();

        // Dados do paciente
        this.pacienteId = fichaMedica.getPaciente().getId();
        this.pacienteNome = fichaMedica.getPaciente().getNome();
        this.pacienteCpf = fichaMedica.getPaciente().getCpf();

        // Dados de saúde geral
        this.problemasRespiratorios = fichaMedica.getProblemasRespiratorios();
        this.problemasAlergicos = fichaMedica.getProblemasAlergicos();
        this.problemasArticulares = fichaMedica.getProblemasArticulares();
        this.diabetes = fichaMedica.getDiabetes();

        // Questionário de Saúde
        this.sofreDoenca = fichaMedica.getSofreDoenca();
        this.quaisDoencas = fichaMedica.getQuaisDoencas();
        this.emTratamentoMedico = fichaMedica.getEmTratamentoMedico();
        this.gravidez = fichaMedica.getGravidez();
        this.usandoMedicacao = fichaMedica.getUsandoMedicacao();
        this.quaisMedicamentos = fichaMedica.getQuaisMedicamentos();
        this.nomeMedicoAssistente = fichaMedica.getNomeMedicoAssistente();
        this.telefoneMedicoAssistente = fichaMedica.getTelefoneMedicoAssistente();
        this.teveAlergia = fichaMedica.getTeveAlergia();
        this.quaisAlergias = fichaMedica.getQuaisAlergias();
        this.jaOperado = fichaMedica.getJaOperado();
        this.quaisCirurgias = fichaMedica.getQuaisCirurgias();
        this.problemasCicatrizacao = fichaMedica.getProblemasCicatrizacao();
        this.problemasAnestesia = fichaMedica.getProblemasAnestesia();
        this.problemasHemorragia = fichaMedica.getProblemasHemorragia();

        // Outras informações
        this.queixaPrincipal = fichaMedica.getQueixaPrincipal();
        this.habitos = fichaMedica.getHabitos();
        this.antecedentesFamiliares = fichaMedica.getAntecedentesFamiliares();

        // Inspeção da boca e da face
        this.lingua = fichaMedica.getLingua();
        this.mucosa = fichaMedica.getMucosa();
        this.palato = fichaMedica.getPalato();
        this.face = fichaMedica.getFace();
        this.labios = fichaMedica.getLabios();
        this.alteracaoOclusao = fichaMedica.getAlteracaoOclusao();
        this.tipoAlteracaoOclusao = fichaMedica.getTipoAlteracaoOclusao();
        this.usaProtese = fichaMedica.getUsaProtese();
        this.tipoProtese = fichaMedica.getTipoProtese();
        this.gengivas = fichaMedica.getGengivas();
        this.nariz = fichaMedica.getNariz();
        this.ganglios = fichaMedica.getGanglios();
        this.glandulasSalivares = fichaMedica.getGlandulasSalivares();
        this.outrasObservacoes = fichaMedica.getOutrasObservacoes();

        this.dataAssinatura = fichaMedica.getDataAssinatura();
        this.assinaturaPaciente = fichaMedica.getAssinaturaPaciente();
    }
}