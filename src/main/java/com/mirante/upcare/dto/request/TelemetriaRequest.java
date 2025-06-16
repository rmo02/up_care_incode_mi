package com.mirante.upcare.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record TelemetriaRequest(
        @Valid
        @NotNull
        EquipamentoRequest equipamento
) {
}
