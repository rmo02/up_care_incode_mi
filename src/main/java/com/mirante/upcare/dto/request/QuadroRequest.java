package com.mirante.upcare.dto.request;

import jakarta.validation.constraints.NotNull;

public record QuadroRequest(
        @NotNull
        EquipamentoRequest equipamento
) {
}
