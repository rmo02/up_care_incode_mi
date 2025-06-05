package com.mirante.upcare.dto.response;

import java.util.UUID;

public record NobreakResponse(
    UUID idNobreak,
    EquipamentoResponse equipamento,
    QuadroResponse quadro,
    Integer tensaoEntrada,
    Integer tensaoSaida
) {}
