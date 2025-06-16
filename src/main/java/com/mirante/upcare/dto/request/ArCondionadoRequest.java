package com.mirante.upcare.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record ArCondionadoRequest(
    @Valid
    @NotNull
    EquipamentoRequest equipamento,

    @NotNull
    Float potencia,

    @NotNull
    Float tensao
) {}
