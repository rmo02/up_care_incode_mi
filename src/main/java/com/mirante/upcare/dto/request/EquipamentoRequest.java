package com.mirante.upcare.dto.request;

import java.util.UUID;

import com.mirante.upcare.models.enums.Categoria;
import com.mirante.upcare.models.enums.StatusTecnico;
import com.mirante.upcare.models.enums.TipoEquipamento;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record EquipamentoRequest(
    @NotNull
    UUID idEstacao,

    @NotBlank
    String marca,
    
    @NotBlank
    String codigo,
    
    @NotBlank
    String modelo,
    
    @NotNull
    Categoria categoria,
    
    @NotNull
    StatusTecnico status,
    
    @NotNull
    TipoEquipamento tipo
) {}
