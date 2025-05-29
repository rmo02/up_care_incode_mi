package com.mirante.upcare.dto.request;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record TarefaEquipamentoRequest(
        @NotNull
        UUID idTarefa,

        @NotNull
        UUID idEquipamento
){}
