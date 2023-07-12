package com.school.jobby.models;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Embeddable
@Data
public class Endereco {
    private Long cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;

    @OneToOne
    @JoinColumn(name = "cidade_id")
    private Cidade cidade;


}
