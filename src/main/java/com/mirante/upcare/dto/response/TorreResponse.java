package com.mirante.upcare.dto.response;

import com.mirante.upcare.models.enums.TipoTorre;

import java.util.UUID;

public record TorreResponse(
        UUID idTorre,
        EquipamentoResponse equipamento,
        TipoTorre tipo,
        Boolean aterrada,
        Float altura
) {
}
