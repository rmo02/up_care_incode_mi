package com.mirante.upcare.dto.response;

import java.util.UUID;

public record ReceptorResponse(
    UUID idReceptor,
    EquipamentoResponse equipamento,
    ParabolicaResponse parabolica,
    TransmissorResponse transmissor,
    Float canal,
    Integer frequencia,
    Integer symbolRate
){}
