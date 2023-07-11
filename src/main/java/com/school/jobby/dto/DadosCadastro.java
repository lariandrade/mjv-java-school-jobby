package com.school.jobby.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public record DadosCadastro(

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
        String email) {

}
