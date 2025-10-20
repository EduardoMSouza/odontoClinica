package com.consultorio.domain.ficha_medica;

import com.consultorio.domain.paciente.Paciente;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "fichas_medica")
public class FichaMedica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Anamnese
    @Column
    private boolean tomandoMedicamento;

    @Column(length = 500)
    private String medicamentosPosologia;

    @Column
    private boolean temAlergia;

    @Column
    private String tipoAlergia;

    @Enumerated(EnumType.STRING)
    @Column
    private PressaoArterial pressao;

    @Column
    private boolean problemaCardiaco;

    @Column
    private String tipoProblemaCardiaco;

    @Column
    private boolean faltaAr;

    @Column
    private boolean diabetes;

    @Enumerated(EnumType.STRING)
    @Column
    private Sangramento sangramento;

    @Enumerated(EnumType.STRING)
    @Column
    private Cicatrizacao cicatrizacao;

    @Column
    private boolean cirurgia;

    @Column
    private boolean gestante;

    @Column
    private Integer semanasGestacao;

    @Column(length = 500)
    private String problemasSaude;

    @Column(length = 500)
    private String queixaPrincipal;

    @Column
    private boolean reacaoAnestesia;

    @Column
    private String tipoReacaoAnestesia;

    @Column
    private String ultimoTratamentoDentario;

    @Column
    private boolean dorDentesGengiva;

    @Column
    private boolean gengivaSangra;

    @Column
    private boolean gengivaSangraHigiene;

    @Column
    private boolean gengivaSangraAsVezes;

    @Column
    private boolean gostoRuimBocaSeca;

    @Column
    private Integer escovacaoDiaria;

    @Column
    private boolean usaFioDental;

    @Column
    private boolean usaFioDentalDiariamente;

    @Column
    private boolean dorEstaloMaxilarOuvido;

    @Column
    private boolean rangeDentes;

    @Column
    private boolean feridaBolhaFaceLabios;

    @Column
    private boolean fuma;

    @Column
    private String quantidadeFumo;

    // Anamnese Direcionada (Queixa 1)
    @ElementCollection
    private List<String> localizacaoQueixa1;

    @Column
    private String qualidadeQueixa1;

    @Column
    private String duracaoQueixa1;

    @Column
    private String inicioQueixa1;

    @Column
    private String intensidadeQueixa1;

    @Column
    private String frequenciaQueixa1;

    @Column
    private String pioraSintomasQueixa1;

    @Column
    private String melhoraSintomasQueixa1;

    @Column
    private String horarioPiorDorQueixa1;

    @Column
    private boolean acordaPorDorQueixa1;

    @Column
    private boolean acordaComDorQueixa1;

    @Column
    private String eventosRelacionadosQueixa1;

    @Column
    private boolean procurouProfissionalQueixa1;

    @Column
    private String profissionalProcuradoQueixa1;

    @Column
    private Integer numeroTratamentosQueixa1;

    @Column(length = 500)
    private String atividadesAfetadasQueixa1;

    @Column
    private boolean senteDorAgoraQueixa1;

    @Column
    private Integer escalaDorQueixa1;

    // Anamnese Direcionada (Queixa 2)
    @ElementCollection
    private List<String> localizacaoQueixa2;

    @Column
    private String qualidadeQueixa2;

    @Column
    private String duracaoQueixa2;

    @Column
    private String inicioQueixa2;

    @Column
    private String intensidadeQueixa2;

    @Column
    private String frequenciaQueixa2;

    @Column
    private String pioraSintomasQueixa2;

    @Column
    private String melhoraSintomasQueixa2;

    @Column
    private String horarioPiorDorQueixa2;

    @Column
    private boolean acordaPorDorQueixa2;

    @Column
    private boolean acordaComDorQueixa2;

    @Column
    private String eventosRelacionadosQueixa2;

    @Column
    private boolean procurouProfissionalQueixa2;

    @Column
    private String profissionalProcuradoQueixa2;

    @Column
    private Integer numeroTratamentosQueixa2;

    @Column(length = 500)
    private String atividadesAfetadasQueixa2;

    @Column
    private boolean senteDorAgoraQueixa2;

    @Column
    private Integer escalaDorQueixa2;

    // História - Questionário
    @Enumerated(EnumType.STRING)
    @Column
    private SaudeGeral saudeGeral;

    @Enumerated(EnumType.STRING)
    @Column
    private SaudeOral saudeOral;

    @Column
    private boolean mulherGravida;

    @Column
    private Integer semanasGravidez;

    @Column
    private boolean climatério;

    @Column
    private boolean menopausa;

    @Column
    private boolean tratamentoMedico;

    @Column(length = 500)
    private String tratamentosMedicos;

    @ElementCollection
    private List<String> condicoesMedicas;

    @Column
    private boolean condicoesFamiliares;

    @Column(length = 500)
    private String condicoesFamiliaresDetalhes;

    @Column(length = 500)
    private String medicamentosAtuais;

    @Column
    private boolean usaChasFitoterapia;

    @Column(length = 500)
    private String chasFitoterapiaDetalhes;

    @Column(length = 500)
    private String historiaMedica;

    // Exame Clínico (parcial, para simplificação)
    @Column
    private boolean assimetriaFacial;

    @Column
    private boolean prognatismo;

    @Column
    private boolean retrognatismo;

    @Column
    private String laterognatismo;

    @Column
    private boolean desdentadoTotal;

    @Column
    private boolean protese;

    @Column
    private boolean perdaDVO;

    @Column
    private String mordidaAberta;

    @Column
    private String mordidaCruzada;

    @Column
    private boolean sobremordidaProfunda;

    // Exame Físico (parcial, para simplificação)
    @Column
    private Double peso;

    @Column
    private Double altura;

    @Column
    private Integer frequenciaCardiaca;

    @Column
    private String pressaoArterial;

    @Column(length = 500)
    private String condicoesDentarias;

    // Novo campo para data de criação (string - mantive conforme sua entidade)
    @Column
    private String dataCriacao;

    public enum PressaoArterial {
        NORMAL, ALTA, BAIXA, CONTROLADA
    }

    public enum Sangramento {
        NORMAL, EXCESSIVO
    }

    public enum Cicatrizacao {
        NORMAL, COMPLICADA
    }

    public enum SaudeGeral {
        EXCELENTE, MUITO_BOA, BOA, RAZOAVEL, PRECARIA
    }

    public enum SaudeOral {
        EXCELENTE, MUITO_BOA, BOA, RAZOAVEL, PRECARIA
    }

    public FichaMedica() {}

    public FichaMedica(String queixaPrincipal) {
        this.queixaPrincipal = queixaPrincipal;
    }

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    @PrePersist
    public void prePersist() {
        if (this.dataCriacao == null) {
            this.dataCriacao = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        }
    }
}
