package com.mirante.upcare.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

import com.mirante.upcare.models.enums.TipoManutencao;

@Entity
@Getter @Setter
public class Manutencao {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "fk_estacao")
    private Estacao estacao;

    /** TODO: Criar entidade tecnico */

    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoManutencao manutencao;

}
