package com.school.jobby.models;

import jakarta.persistence.Embeddable;

@Embeddable
public class Celular {
    private Long numero_celular;
    private boolean whatsapp;
}
