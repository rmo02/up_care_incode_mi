package com.mirante.upcare.models;

import java.util.UUID;

import com.mirante.upcare.models.enums.Categoria;
import com.mirante.upcare.models.enums.StatusTecnico;
import com.mirante.upcare.models.enums.TipoEquipamento;

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
public class Equipamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "fk_estacao")
    private Estacao estacao;

    @NotBlank
    private String marca;
    
    @NotBlank
    private String codigo;
    
    @NotBlank
    private String modelo;
    
    @NotNull
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    
    @NotNull
    @Enumerated(EnumType.STRING)
    private StatusTecnico status;
    
    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoEquipamento tipo;
}
