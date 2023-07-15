package com.school.jobby.dtos.cadastro.experiencia;

import com.school.jobby.models.CadastroExperiencia;

public record DadosDetalhamentoExperiencia(Integer id, String nomeEmpresa, Double salario, boolean empregoAtual) {
    public DadosDetalhamentoExperiencia(CadastroExperiencia cadExperiencia) {
        this(cadExperiencia.getId(), cadExperiencia.getNomeEmpresa(), cadExperiencia.getSalario(), cadExperiencia.isEmpregoAtual());
    }
}
