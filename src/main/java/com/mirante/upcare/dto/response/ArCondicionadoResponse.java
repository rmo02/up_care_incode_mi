package com.mirante.upcare.dto.response;

import java.util.UUID;

public record ArCondicionadoResponse (
        UUID idArCondicionado,
        EquipamentoResponse equipamento,
        Float potencia,
        Float tensao
){}
