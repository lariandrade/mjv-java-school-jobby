package com.school.jobby.dtos.cadastro.candidato;

import jakarta.validation.constraints.NotBlank;

public record DadosCidadeDTO(
        @NotBlank
        String nome,
        @NotBlank
        String estado,
        @NotBlank
        String sigla) {}
