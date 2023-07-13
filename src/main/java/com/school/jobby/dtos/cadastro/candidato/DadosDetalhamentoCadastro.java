package com.school.jobby.dtos.cadastro.candidato;

import com.school.jobby.models.Cadastro;

public record DadosDetalhamentoCadastro(Integer id, String nome) {
    public DadosDetalhamentoCadastro(Cadastro cadastro) {
        this(cadastro.getId(), cadastro.getNome());
    }
}
