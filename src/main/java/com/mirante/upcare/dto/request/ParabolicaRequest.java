package com.mirante.upcare.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ParabolicaRequest(
    @NotNull
    EquipamentoRequest equipamento,

    @NotNull
    Float diametro,

    @NotBlank
    String satelite

) {}
