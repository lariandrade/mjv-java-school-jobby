package com.school.jobby.dtos.cadastro.candidato;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosEnderecoDTO(
        @NotNull
        Long cep,
        @NotBlank
        String logradouro,
        @NotBlank
        String numero,
        String complemento,
        @NotBlank
        String bairro,
        @NotNull
        @Valid
        DadosCidadeDTO cidade

) {

}

