package com.mirante.upcare.dto.response;

import java.util.UUID;

public record QuadroResponse(
        UUID idQuadro,
        EquipamentoResponse equipamento
) {
}
