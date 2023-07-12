package com.school.jobby.models;

import com.school.jobby.dto.DadosProfissaoDTO;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Entity
@Table(name = "tb_profissao")
@Data
public class Profissao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer id;
    private String nome;

    public Profissao(DadosProfissaoDTO dados) {
        this.nome = dados.nome();
    }
}
