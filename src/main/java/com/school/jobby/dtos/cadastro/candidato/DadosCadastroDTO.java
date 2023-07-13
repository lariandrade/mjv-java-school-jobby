package com.school.jobby.dtos.cadastro.candidato;

import com.school.jobby.enums.Sexo;
import com.school.jobby.models.Celular;
import com.school.jobby.models.PretencaoSalarial;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public record DadosCadastroDTO(
        @NotBlank
        String nome,
        @NotBlank
        @Pattern(regexp = "\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2}")
        String CPF,
        @NotNull
        LocalDate dataNascimento,
        @NotNull
        Long telefone,
        @NotBlank
        @Email
        String email,
        @NotNull
        @Valid
        DadosEnderecoDTO endereco,
        @NotNull
        Sexo sexo,
        @NotNull
        @Valid
        Celular celular,
        @NotNull
        @Valid
        PretencaoSalarial pretencaoSalarial,
        @NotNull
        @Valid
        DadosProfissaoDTO profissao,
        @NotNull
        String habilidades

) {

}
