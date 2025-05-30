package com.mirante.upcare.dto.response;

import java.util.UUID;

public record ExaustorResponse(
        UUID idExaustor,
        EquipamentoResponse equipamento
        ) {}
