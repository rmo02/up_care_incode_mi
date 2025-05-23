package com.mirante.upcare.dto.response;

import java.util.UUID;

public record ParabolicaResponse (
    UUID idParabolica,
    EquipamentoResponse equipamento,
    Float diametro,
    String satelite
){}
