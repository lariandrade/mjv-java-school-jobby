package com.school.jobby.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.school.jobby.dtos.cadastro.candidato.DadosProfissaoDTO;
import com.school.jobby.dtos.cadastro.experiencia.DadosExperienciaDTO;
import com.school.jobby.enums.RegimeContratacao;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_cadastroExperiencia")
@Data
@NoArgsConstructor
public class CadastroExperiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer id;
    private String nomeEmpresa;
    private Double salario;
    private boolean empregoAtual;
    private LocalDate dataContratacao;
    private LocalDate dataDesligamento;

    @Enumerated(EnumType.STRING)
    private RegimeContratacao regimeContratacao;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profissao_id")
    private Profissao profissao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cadastro_id")
    @JsonBackReference
    private Cadastro cadastro;

    public CadastroExperiencia(DadosExperienciaDTO dados) {
        this.nomeEmpresa = dados.nomeEmpresa();
        this.salario = dados.salario();
        this.empregoAtual = dados.empregoAtual();
        this.dataContratacao = dados.dataContratacao();
        this.dataDesligamento = dados.dataDesligamento();
        //TODO: logica -> se nao for emprego atual, inserir data desligamento
        this.regimeContratacao = dados.regimeContratacao();
        this.profissao = new Profissao(dados.profissao());;
        this.cadastro = dados.cadastro();
    }
}
