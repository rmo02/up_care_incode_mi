package com.mirante.upcare.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record CombinadorRequest(
        @Valid
        @NotNull
        EquipamentoRequest equipamento
) {
}
