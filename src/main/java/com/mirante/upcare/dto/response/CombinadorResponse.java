package com.mirante.upcare.dto.response;

import java.util.UUID;

public record CombinadorResponse(
   UUID idCombinador,
   EquipamentoResponse equipamento
) {}
