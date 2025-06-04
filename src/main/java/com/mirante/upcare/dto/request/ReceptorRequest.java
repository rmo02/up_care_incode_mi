package com.mirante.upcare.dto.request;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public record ReceptorRequest(
    @NotNull
    EquipamentoRequest equipamento,

    @NotNull
    UUID parabolica,

    @NotNull
    UUID transmissor,
    
    @NotNull
    Float canal,

    @NotNull
    Integer frequencia,
   
    @NotNull
    Integer symbolRate

) {}
