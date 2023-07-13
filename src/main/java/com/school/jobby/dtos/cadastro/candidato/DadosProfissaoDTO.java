package com.school.jobby.dtos.cadastro.candidato;

import jakarta.validation.constraints.NotBlank;

public record DadosProfissaoDTO(
        @NotBlank
        String nome) {
}
