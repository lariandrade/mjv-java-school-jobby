package com.school.jobby.models;

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
    private List<String> habilidades;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @Embedded
    private Celular celular;

    @Embedded
    private Endereco endereco;

    @Embedded
    private PretencaoSalarial pretencaoSalarial;

    @OneToOne
    @JoinColumn(name = "profissao_id")
    private Profissao profissao;

}
