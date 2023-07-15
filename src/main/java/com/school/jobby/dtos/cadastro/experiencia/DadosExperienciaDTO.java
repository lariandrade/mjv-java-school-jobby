package com.school.jobby.dtos.cadastro.experiencia;

import com.school.jobby.dtos.cadastro.candidato.DadosProfissaoDTO;
import com.school.jobby.enums.RegimeContratacao;
import com.school.jobby.models.Cadastro;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosExperienciaDTO(
        @NotBlank
        String nomeEmpresa,
        @NotNull
        Double salario,
        @NotNull
        Boolean empregoAtual,
        @NotNull
        LocalDate dataContratacao,

        LocalDate dataDesligamento,
        @NotNull
        RegimeContratacao regimeContratacao,
        @NotNull
        DadosProfissaoDTO profissao,

        Cadastro cadastro) {}
