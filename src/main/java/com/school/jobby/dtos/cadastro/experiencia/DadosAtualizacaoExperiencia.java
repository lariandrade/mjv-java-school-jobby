package com.school.jobby.dtos.cadastro.experiencia;

import com.school.jobby.enums.RegimeContratacao;
import com.school.jobby.models.Profissao;

import java.time.LocalDateTime;

public record DadosAtualizacaoExperiencia(
        String nomeEmpresa,
        Double salario,
        Boolean empregoAtual,
        LocalDateTime dataContratacao,
        LocalDateTime dataDesligamento,
        RegimeContratacao regimeContratacao,
        Profissao profissao) {}
