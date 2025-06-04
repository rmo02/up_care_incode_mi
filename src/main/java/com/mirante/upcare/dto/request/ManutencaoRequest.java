package com.mirante.upcare.dto.request;

import java.util.UUID;

import com.mirante.upcare.models.enums.TipoManutencao;

import jakarta.validation.constraints.NotNull;

public record ManutencaoRequest(

    @NotNull
    UUID idEstacao,

    @NotNull
    UUID idTecnico,

    @NotNull
    TipoManutencao tipo

) {}
