package com.mirante.upcare.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

@Entity
public class Switch {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "fk_equipamento")
    private Equipamento equipamento;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "fk_quadro")
    private Quadro quadro;

    @NotNull
    private Integer qtd_portas;
}
