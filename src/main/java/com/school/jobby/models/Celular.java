package com.school.jobby.models;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Embeddable
@Data
public class Celular {
    @NotNull
    private Long numero_celular;
    @NotNull
    private boolean whatsapp;

}
