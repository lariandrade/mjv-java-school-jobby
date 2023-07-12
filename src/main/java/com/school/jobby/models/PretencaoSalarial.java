package com.school.jobby.models;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Embeddable
@Data
public class PretencaoSalarial {
    @NotNull
    private Double valorMinimo;
    @NotNull
    private Double valorMaximo;
}
