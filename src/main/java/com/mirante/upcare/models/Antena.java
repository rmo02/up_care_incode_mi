package com.mirante.upcare.models;

import java.util.UUID;

import com.mirante.upcare.models.enums.PosicaoAntena;
import com.mirante.upcare.models.enums.TipoAntena;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Antena {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "fk_equipamento")
    private Equipamento equipamento;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "fk_transmissor")
    private Transmissor transmissor;

    @NotBlank
    private String gain;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoAntena tipo;

    @NotNull
    @Enumerated(EnumType.STRING)
    private PosicaoAntena posicao;
  
    @NotNull
    private Float vr;
}
