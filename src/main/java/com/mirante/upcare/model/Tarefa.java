package com.mirante.upcare.model;

import com.mirante.upcare.model.enumarate.StatusTarefa;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

@Entity
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "fk_manutencao")
    private Manutencao manutencao;


    /** TODO: criar relacionamento muitos para muitos com equipamento '*/


    @NotNull
    @Enumerated(EnumType.STRING)
    private StatusTarefa statusTarefa;

    @NotBlank
    private String descricao;

    @NotNull
    private Boolean fotoObrigatoria;

    /** TODO: criar foto antes */

    /** TODO: criar foto depois */

}
