package com.mirante.upcare.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
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

    @NotNull
    @ManyToOne
    @JoinColumn(name = "fk_tecnico")
    private Usuario tecnico;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoManutencao tipo;

    @OneToMany(mappedBy = "manutencao", cascade = CascadeType.REMOVE)
    private List<Tarefa> tarefas;

}
