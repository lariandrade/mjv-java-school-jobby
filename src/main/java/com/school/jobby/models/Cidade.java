package com.school.jobby.models;

import com.school.jobby.dtos.cadastro.candidato.DadosCidadeDTO;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_cidade")
@Data
@NoArgsConstructor
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;
    private String nome;
    private String estado;
    private String sigla;

    public Cidade(DadosCidadeDTO dados) {
        this.nome = dados.nome();
        this.estado = dados.estado();
        this.sigla = dados.sigla();
    }
}
