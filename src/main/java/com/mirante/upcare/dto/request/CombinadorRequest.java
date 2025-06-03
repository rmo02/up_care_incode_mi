package com.mirante.upcare.dto.request;

import jakarta.validation.constraints.NotNull;

public record CombinadorRequest(
        @NotNull
        EquipamentoRequest equipamento
) {
}
