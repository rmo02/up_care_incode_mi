package com.mirante.upcare.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter @Setter
public class Disjuntor {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_equipamento")
    private Equipamento equipamento;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "fk_quadro")
    private Quadro quadro;

    @NotNull
    private Float correnteMaxima;
}
