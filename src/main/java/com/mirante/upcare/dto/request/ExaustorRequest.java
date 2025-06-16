package com.mirante.upcare.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record ExaustorRequest(
        @Valid
        @NotNull
        EquipamentoRequest equipamento
) {
}
