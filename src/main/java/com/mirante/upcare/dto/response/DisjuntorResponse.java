package com.mirante.upcare.dto.response;

import java.util.UUID;

public record DisjuntorResponse(
    UUID idDisjuntor,
    EquipamentoResponse equipamento,
    QuadroResponse quadro,
    Float correnteMaxima
) {}
