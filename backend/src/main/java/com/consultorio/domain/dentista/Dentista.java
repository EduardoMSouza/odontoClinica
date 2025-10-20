package com.consultorio.domain.dentista;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "dentistas")
@Getter @Setter
public class Dentista {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) private String nome;
    @Column(nullable = false, unique = true) private String cro;
    @Column private String especialidade;
    @Column private String telefone;
    @Column private String email;
    @Column private Boolean ativo = true;

    public Dentista(){}
    public Dentista(Long id){ this.id = id; } // auxiliar para referências rápidas
}
