package com.mirante.upcare.dto.response;

import java.util.UUID;

public record SwitchResponse(
    UUID idSwitch,
    EquipamentoResponse equipamento,
    QuadroResponse quadro,
    Integer qtdPortas
) {}
