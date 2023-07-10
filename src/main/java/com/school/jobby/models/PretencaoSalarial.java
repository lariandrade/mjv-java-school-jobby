package com.school.jobby.models;

import jakarta.persistence.Embeddable;

@Embeddable
public class PretencaoSalarial {
    private Double valorMinimo;
    private Double valorMaximo;
}
