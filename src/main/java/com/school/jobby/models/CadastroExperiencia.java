package com.school.jobby.models;

import com.school.jobby.enums.RegimeContratacao;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class CadastroExperiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double salario;
    private boolean EmpregoAtual;
    private LocalDateTime dataContratação;
    private LocalDateTime dataDesligamento;

    @Enumerated(EnumType.STRING)
    private RegimeContratacao regimeContratacao;

    @OneToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    @OneToOne
    @JoinColumn(name = "profissao_id")
    private Profissao profissao;

    @OneToOne
    @JoinColumn(name = "cadastro_id")
    private Cadastro cadastro;

}
