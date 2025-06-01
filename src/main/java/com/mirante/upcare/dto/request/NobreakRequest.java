package com.mirante.upcare.dto.request;

import jakarta.validation.constraints.NotNull;

public record NobreakRequest(
        @NotNull
        EquipamentoRequest equipamento,

        @NotNull
        QuadroRequest quadro,

        @NotNull
        Integer tensaoEntrada,

        @NotNull
        Integer tensaoSaida
) {
}
