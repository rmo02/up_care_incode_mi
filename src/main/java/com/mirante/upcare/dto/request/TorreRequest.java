package com.mirante.upcare.dto.request;

import com.mirante.upcare.models.enums.TipoTorre;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record TorreRequest(
    @Valid
    @NotNull
    EquipamentoRequest equipamento,

    @NotNull
    TipoTorre tipo,

    @NotNull
    Boolean aterrada,

    @NotNull
    Float altura
) {}
