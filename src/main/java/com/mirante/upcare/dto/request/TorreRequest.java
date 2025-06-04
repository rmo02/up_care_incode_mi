package com.mirante.upcare.dto.request;

import com.mirante.upcare.models.enums.TipoTorre;
import jakarta.validation.constraints.NotNull;

public record TorreRequest(
        @NotNull
        EquipamentoRequest equipamento,

        @NotNull
        TipoTorre torre,

        @NotNull
        Boolean aterrada,

        @NotNull
        Float altura
) {
}
