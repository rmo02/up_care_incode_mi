package com.mirante.upcare.dto.response;
import java.util.List;
import java.util.UUID;

import com.mirante.upcare.models.enums.StatusTarefa;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TarefaResponse {
    private UUID idTarefa;
    private ManutencaoResponse manutencao;
    private StatusTarefa status;
    private String descricao;
    private List<EquipamentoResponse> equipamentos;
}

