package com.mirante.upcare.models;

import com.mirante.upcare.models.enums.TipoCabo;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Entity
@Getter @Setter
public class Cabo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "fk_equipamento")
    private Equipamento equipamento;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoCabo tipo;

    @NotNull
    private Float tamanho;


}
