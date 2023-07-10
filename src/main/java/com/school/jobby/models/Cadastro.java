package com.school.jobby.models;

import com.school.jobby.enums.Sexo;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "cadastro")
public class Cadastro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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


}
