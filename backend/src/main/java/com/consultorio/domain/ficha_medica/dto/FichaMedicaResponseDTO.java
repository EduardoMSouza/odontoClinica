package com.consultorio.domain.ficha_medica.dto;

import com.consultorio.domain.ficha_medica.FichaMedica;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FichaMedicaResponseDTO {

    private Long id;
    private Long pacienteId;
    private String pacienteNome; // convenience
    private String queixaPrincipal;
    private String dataCriacao;

    private AnamneseDTO anamnese;
    private QueixaDTO queixa1;
    private QueixaDTO queixa2;
    private HistoriaDTO historia;
    private ExameClinicoDTO exameClinico;
    private ExameFisicoDTO exameFisico;

    public FichaMedicaResponseDTO() {}

    // Sub DTOs
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AnamneseDTO {
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
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class QueixaDTO {
        private List<String> localizacao;
        private String qualidade;
        private String duracao;
        private String inicio;
        private String intensidade;
        private String frequencia;
        private String pioraSintomas;
        private String melhoraSintomas;
        private String horarioPiorDor;
        private boolean acordaPorDor;
        private boolean acordaComDor;
        private String eventosRelacionados;
        private boolean procurouProfissional;
        private String profissionalProcurado;
        private Integer numeroTratamentos;
        private String atividadesAfetadas;
        private boolean senteDorAgora;
        private Integer escalaDor;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class HistoriaDTO {
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
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ExameClinicoDTO {
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
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ExameFisicoDTO {
        private Double peso;
        private Double altura;
        private Integer frequenciaCardiaca;
        private String pressaoArterial;
        private String condicoesDentarias;
    }
}
