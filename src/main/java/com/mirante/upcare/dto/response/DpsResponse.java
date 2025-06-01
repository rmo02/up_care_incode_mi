package com.mirante.upcare.dto.response;

import com.mirante.upcare.models.enums.ClasseDps;

import java.util.UUID;

public record DpsResponse(
        UUID idDps,
        EquipamentoResponse equipamento,
        QuadroResponse quadro,
        ClasseDps classeDps
) {
}
