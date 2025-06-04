package com.mirante.upcare.dto.request;

import java.util.List;
import java.util.UUID;

import com.mirante.upcare.models.enums.StatusTarefa;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record TarefaRequest(

    @NotNull
    UUID idManutencao,

    @NotNull
    StatusTarefa status,

    @NotBlank
    String descricao,

    @NotNull
    @Size(min = 1)
    List<UUID> equipamentos
){}
