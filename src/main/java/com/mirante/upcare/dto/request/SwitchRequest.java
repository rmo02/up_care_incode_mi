package com.mirante.upcare.dto.request;

import jakarta.validation.constraints.NotNull;

public record SwitchRequest(
        @NotNull
        EquipamentoRequest equipamento,

        @NotNull
        QuadroRequest quadro,

        @NotNull
        Integer qtdPortas
) {
}
