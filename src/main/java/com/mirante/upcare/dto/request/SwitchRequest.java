package com.mirante.upcare.dto.request;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record SwitchRequest(
        @NotNull
        EquipamentoRequest equipamento,

        @NotNull
        UUID idQuadro,

        @NotNull
        Integer qtdPortas
) {
}
