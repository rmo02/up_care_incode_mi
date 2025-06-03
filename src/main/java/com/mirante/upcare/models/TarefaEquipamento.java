package com.mirante.upcare.models;

import java.util.UUID;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class TarefaEquipamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "fk_tarefa")
    private Tarefa tarefa;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "fk_equipamento")
    private Equipamento equipamento;
}
