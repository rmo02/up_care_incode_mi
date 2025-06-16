package com.mirante.upcare.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record QuadroRequest(
    @Valid
    @NotNull
    EquipamentoRequest equipamento
) {}
