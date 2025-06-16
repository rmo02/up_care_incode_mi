package com.mirante.upcare.dto.request;

import java.util.UUID;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record ReceptorRequest(
    @Valid
    @NotNull
    EquipamentoRequest equipamento,

    @NotNull
    UUID idParabolica,

    @NotNull
    UUID idTransmissor,
    
    @NotNull
    Float canal,

    @NotNull
    Integer frequencia,
   
    @NotNull
    Integer symbolRate

) {}
