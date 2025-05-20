package com.mirante.upcare.models;

import com.mirante.upcare.models.enums.TipoTorre;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter @Setter
public class Torre {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "fk_equipamento")
    private Equipamento equipamento;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoTorre tipo;

    @NotNull
    private Boolean aterrada;

    @NotNull
    private Float altura;

}
