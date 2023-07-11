package com.school.jobby.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosCidadeDTO(
        @NotBlank
        String nome,
        @NotBlank
        String estado,
        @NotBlank
        String sigla) {}
