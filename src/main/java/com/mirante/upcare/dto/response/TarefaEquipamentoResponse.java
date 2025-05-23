package com.mirante.upcare.dto.response;

import java.util.UUID;

public record TarefaEquipamentoResponse(
        UUID idTarefaEquipamento,
        TarefaResponse tarefa,
        EquipamentoResponse equipamento
){}
