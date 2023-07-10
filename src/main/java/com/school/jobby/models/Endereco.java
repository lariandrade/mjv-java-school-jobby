package com.school.jobby.models;

import jakarta.persistence.Embeddable;

@Embeddable
public class Endereco {
    private Long cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;

}
