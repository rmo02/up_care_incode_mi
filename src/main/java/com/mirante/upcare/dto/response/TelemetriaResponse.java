package com.mirante.upcare.dto.response;

import java.util.UUID;

public record TelemetriaResponse (
        UUID idTelemetria,
        EquipamentoResponse equipamento
)
{}
