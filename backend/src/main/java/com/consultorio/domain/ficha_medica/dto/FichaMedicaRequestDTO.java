package com.consultorio.domain.ficha_medica.dto;

import com.consultorio.domain.ficha_medica.FichaMedica;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FichaMedicaRequestDTO {

    @NotNull(message = "pacienteId é obrigatório")
    private Long pacienteId;

    @NotBlank(message = "Queixa principal é obrigatória")
    private String queixaPrincipal;

    private boolean tomandoMedicamento;
    private String medicamentosPosologia;
    private boolean temAlergia;
    private String tipoAlergia;
    private FichaMedica.PressaoArterial pressao;
    private boolean problemaCardiaco;
    private String tipoProblemaCardiaco;
    private boolean faltaAr;
    private boolean diabetes;
    private FichaMedica.Sangramento sangramento;
    private FichaMedica.Cicatrizacao cicatrizacao;
    private boolean cirurgia;
    private boolean gestante;
    private Integer semanasGestacao;
    private String problemasSaude;
    private boolean reacaoAnestesia;
    private String tipoReacaoAnestesia;
    private String ultimoTratamentoDentario;
    private boolean dorDentesGengiva;
    private boolean gengivaSangra;
    private boolean gengivaSangraHigiene;
    private boolean gengivaSangraAsVezes;
    private boolean gostoRuimBocaSeca;
    private Integer escovacaoDiaria;
    private boolean usaFioDental;
    private boolean usaFioDentalDiariamente;
    private boolean dorEstaloMaxilarOuvido;
    private boolean rangeDentes;
    private boolean feridaBolhaFaceLabios;
    private boolean fuma;
    private String quantidadeFumo;

    // Queixa 1
    private List<String> localizacaoQueixa1;
    private String qualidadeQueixa1;
    private String duracaoQueixa1;
    private String inicioQueixa1;
    private String intensidadeQueixa1;
    private String frequenciaQueixa1;
    private String pioraSintomasQueixa1;
    private String melhoraSintomasQueixa1;
    private String horarioPiorDorQueixa1;
    private boolean acordaPorDorQueixa1;
    private boolean acordaComDorQueixa1;
    private String eventosRelacionadosQueixa1;
    private boolean procurouProfissionalQueixa1;
    private String profissionalProcuradoQueixa1;
    private Integer numeroTratamentosQueixa1;
    private String atividadesAfetadasQueixa1;
    private boolean senteDorAgoraQueixa1;
    private Integer escalaDorQueixa1;

    // Queixa 2
    private List<String> localizacaoQueixa2;
    private String qualidadeQueixa2;
    private String duracaoQueixa2;
    private String inicioQueixa2;
    private String intensidadeQueixa2;
    private String frequenciaQueixa2;
    private String pioraSintomasQueixa2;
    private String melhoraSintomasQueixa2;
    private String horarioPiorDorQueixa2;
    private boolean acordaPorDorQueixa2;
    private boolean acordaComDorQueixa2;
    private String eventosRelacionadosQueixa2;
    private boolean procurouProfissionalQueixa2;
    private String profissionalProcuradoQueixa2;
    private Integer numeroTratamentosQueixa2;
    private String atividadesAfetadasQueixa2;
    private boolean senteDorAgoraQueixa2;
    private Integer escalaDorQueixa2;

    // História - Questionário
    private FichaMedica.SaudeGeral saudeGeral;
    private FichaMedica.SaudeOral saudeOral;
    private boolean mulherGravida;
    private Integer semanasGravidez;
    private boolean climatério;
    private boolean menopausa;
    private boolean tratamentoMedico;
    private String tratamentosMedicos;
    private List<String> condicoesMedicas;
    private boolean condicoesFamiliares;
    private String condicoesFamiliaresDetalhes;
    private String medicamentosAtuais;
    private boolean usaChasFitoterapia;
    private String chasFitoterapiaDetalhes;
    private String historiaMedica;

    // Exame Clínico
    private boolean assimetriaFacial;
    private boolean prognatismo;
    private boolean retrognatismo;
    private String laterognatismo;
    private boolean desdentadoTotal;
    private boolean protese;
    private boolean perdaDVO;
    private String mordidaAberta;
    private String mordidaCruzada;
    private boolean sobremordidaProfunda;

    // Exame Físico
    private Double peso;
    private Double altura;
    private Integer frequenciaCardiaca;
    private String pressaoArterial;
    private String condicoesDentarias;
}
