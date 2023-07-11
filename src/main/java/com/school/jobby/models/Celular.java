package com.school.jobby.models;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;

@Embeddable
public class Celular {
    @NotNull
    private Long numero_celular;
    @NotNull
    private boolean whatsapp;

    public Long getNumero_celular() {
        return numero_celular;
    }

    public void setNumero_celular(Long numero_celular) {
        this.numero_celular = numero_celular;
    }

    public boolean isWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(boolean whatsapp) {
        this.whatsapp = whatsapp;
    }
}
