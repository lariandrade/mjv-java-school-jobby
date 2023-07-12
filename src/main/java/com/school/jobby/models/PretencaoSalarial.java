package com.school.jobby.models;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class PretencaoSalarial {
    private Double valorMinimo;
    private Double valorMaximo;
}
