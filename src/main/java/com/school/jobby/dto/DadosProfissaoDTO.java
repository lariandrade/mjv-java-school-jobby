package com.school.jobby.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosProfissaoDTO(
        @NotBlank
        String nome) {
}
