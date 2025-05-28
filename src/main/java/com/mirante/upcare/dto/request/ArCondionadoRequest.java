package com.mirante.upcare.dto.request;

import jakarta.validation.constraints.NotNull;

public record ArCondionadoRequest(
    @NotNull
    EquipamentoRequest equipamento,

    @NotNull
    Float potencia,

    @NotNull
    Float tensao
) {}
