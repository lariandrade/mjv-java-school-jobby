package com.school.jobby.dto;

import com.school.jobby.models.Cidade;
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

