package com.mirante.upcare.models;

import com.mirante.upcare.models.enums.ClasseDps;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

@Entity
public class Dps {

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
    @Enumerated(EnumType.STRING)
    private ClasseDps classeDps;
}
