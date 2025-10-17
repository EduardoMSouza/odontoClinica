package com.consultorio.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "ficha_medica")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FichaMedica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    @Column(nullable = false)
    private LocalDateTime dataCriacao;

    // === DADOS DE SAÚDE GERAL (FORMULÁRIO) ===
    private Boolean problemasRespiratorios;     // ✅ Do formulário
    private Boolean problemasAlergicos;         // ✅ Do formulário
    private Boolean problemasArticulares;       // ✅ Do formulário
    private Boolean diabetes;                   // ✅ Do formulário

    // === QUESTIONÁRIO DE SAÚDE (FORMULÁRIO) ===
    private Boolean sofreDoenca;

    @ElementCollection
    @CollectionTable(name = "ficha_doencas", joinColumns = @JoinColumn(name = "ficha_medica_id"))
    private List<String> quaisDoencas;          // "Qual(is)" do formulário

    private Boolean emTratamentoMedico;
    private Boolean gravidez;
    private Boolean usandoMedicacao;

    @ElementCollection
    @CollectionTable(name = "ficha_medicamentos", joinColumns = @JoinColumn(name = "ficha_medica_id"))
    private List<String> quaisMedicamentos;     // "Qual(is)" do formulário

    private String nomeMedicoAssistente;
    private String telefoneMedicoAssistente;

    private Boolean teveAlergia;

    @ElementCollection
    @CollectionTable(name = "ficha_alergias", joinColumns = @JoinColumn(name = "ficha_medica_id"))
    private List<String> quaisAlergias;         // "Qual(is)" do formulário

    private Boolean jaOperado;

    @ElementCollection
    @CollectionTable(name = "ficha_cirurgias", joinColumns = @JoinColumn(name = "ficha_medica_id"))
    private List<String> quaisCirurgias;        // "Qual(is)" do formulário

    private Boolean problemasCicatrizacao;
    private Boolean problemasAnestesia;
    private Boolean problemasHemorragia;

    // === OUTRAS INFORMAÇÕES ===
    @Column(length = 1000)
    private String queixaPrincipal;             // ✅ Do formulário

    private String habitos;                     // ✅ Do formulário

    @ElementCollection
    @CollectionTable(name = "ficha_antecedentes_familiares", joinColumns = @JoinColumn(name = "ficha_medica_id"))
    private List<String> antecedentesFamiliares; // ✅ Do formulário

    // === INSPEÇÃO DA BOCA E FACE ===
    private String lingua;
    private String mucosa;
    private String palato;
    private String face;
    private String labios;
    private Boolean alteracaoOclusao;
    private String tipoAlteracaoOclusao;        // "Tipo" do formulário
    private Boolean usaProtese;
    private String tipoProtese;                 // "Tipo" do formulário
    private String gengivas;
    private String nariz;
    private String ganglios;
    private String glandulasSalivares;

    @Column(length = 1000)
    private String outrasObservacoes;           // ✅ Do formulário

    private LocalDateTime dataAssinatura;
    private String assinaturaPaciente;          // Assinatura do Paciente


}