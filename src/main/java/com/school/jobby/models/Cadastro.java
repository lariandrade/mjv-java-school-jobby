package com.school.jobby.models;

import com.school.jobby.dto.DadosCadastroDTO;
import com.school.jobby.enums.Sexo;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tb_cadastro")
@Data
public class Cadastro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer id;

    private String nome;
    private String CPF;
    private LocalDate dataNascimento;
    private Long telefone;
    private String email;

    private String habilidades;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @Embedded
    private Celular celular;

    @Embedded
    private Endereco endereco;

    @Embedded
    private PretencaoSalarial pretencaoSalarial;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "profissao_id")
    private Profissao profissao;

    public Cadastro(DadosCadastroDTO dados) {
        this.nome = dados.nome();
        this.CPF = dados.CPF();
        this.dataNascimento = dados.dataNascimento();
        this.telefone = dados.telefone();
        this.email = dados.email();
        this.sexo = dados.sexo();
        this.celular = dados.celular();
        this.endereco = new Endereco(dados.endereco());
        this.profissao = new Profissao(dados.profissao());
        this.pretencaoSalarial = dados.pretencaoSalarial();
        this.habilidades = dados.habilidades();
    }
}
