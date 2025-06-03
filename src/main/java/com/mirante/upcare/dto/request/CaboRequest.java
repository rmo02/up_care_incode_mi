package com.mirante.upcare.dto.request;

import com.mirante.upcare.models.enums.TipoCabo;
import jakarta.validation.constraints.NotNull;

public record CaboRequest(
    @NotNull
    EquipamentoRequest equipamento,

    @NotNull
    Float tamanho,

    @NotNull
    TipoCabo cabo
)
{}
