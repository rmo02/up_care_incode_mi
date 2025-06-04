package com.mirante.upcare.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

import com.mirante.upcare.models.enums.StatusTarefa;

@Entity
@Getter @Setter
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "fk_manutencao")
    private Manutencao manutencao;

    @NotNull
    @Enumerated(EnumType.STRING)
    private StatusTarefa status;

    @NotBlank
    private String descricao;

    @OneToMany(mappedBy = "tarefa", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<TarefaEquipamento> tarefaEquipamentos;

//    @NotNull
//    private Boolean fotoObrigatoria;
//
//    @NotNull
//    @ManyToOne
//    @JoinColumn(name = "fk_foto_antes")
//    private File fotoAntes;
//
//    @NotNull
//    @ManyToOne
//    @JoinColumn(name = "fk_foto_depois")
//    private File fotoDepois;
}
