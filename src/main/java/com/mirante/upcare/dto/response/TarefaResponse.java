package com.mirante.upcare.dto.response;
import com.mirante.upcare.models.enums.StatusTarefa;
import java.util.UUID;

public record TarefaResponse(
        UUID idTarefa,
        ManutencaoResponse manutencao,
        StatusTarefa statusTarefa,
        String descricao,
        Boolean fotoObrigatoria
){}
