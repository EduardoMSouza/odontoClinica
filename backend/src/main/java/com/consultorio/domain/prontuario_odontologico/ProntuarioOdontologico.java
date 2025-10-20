package com.consultorio.domain.prontuario_odontologico;


import com.consultorio.domain.ficha_medica.FichaMedica;
import com.consultorio.domain.paciente.Paciente;
import com.consultorio.domain.profissional.Profissional;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Getter
@Setter
public class ProntuarioOdontologico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String numeroProntuario;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "profissional_id", nullable = false)
    private Profissional profissional;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "ficha_medica_id")
    private FichaMedica fichaMedica;

    // Plano de Tratamento
    @Column
    private String opcaoTratamento;

    @Column(length = 1000)
    private String propositosOpcao1;

    @Column(length = 1000)
    private String riscosOpcao1;

    @Column
    private String custosOpcao1;

    @Column(length = 1000)
    private String propositosOpcao2;

    @Column(length = 1000)
    private String riscosOpcao2;

    @Column
    private String custosOpcao2;

    @Column(length = 1000)
    private String propositosOpcao3;

    @Column(length = 1000)
    private String riscosOpcao3;

    @Column
    private String custosOpcao3;

    @Column
    private String dataConsentimento;

    @Column
    private String assinaturaPaciente;

    @Column
    private String assinaturaProfissional;

    // Ficha Clínica
    @ElementCollection
    private List<FichaClinicaEntrada> fichaClinica;

    public ProntuarioOdontologico() {}

    public ProntuarioOdontologico(String numeroProntuario, Paciente paciente, Profissional profissional, FichaMedica fichaMedica) {
        this.numeroProntuario = numeroProntuario;
        this.paciente = paciente;
        this.profissional = profissional;
        this.fichaMedica = fichaMedica;
    }

    @Embeddable
    @Getter
    @Setter
    public static class FichaClinicaEntrada {
        @Column
        private String data;

        @Column(length = 1000)
        private String evolucaoIntercorrencias;

        @Column
        private String assinaturaPaciente;

        @Column
        private String assinaturaProfissional;
    }
}