package com.mirante.upcare.dto.request;

import jakarta.validation.constraints.NotNull;

public record DisjuntorRequest(
        @NotNull
        EquipamentoRequest equipamento,

        @NotNull
        QuadroRequest quadro,

        @NotNull
        Float correnteMaxima
) {
}
