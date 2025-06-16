package com.mirante.upcare.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record DisjuntorRequest(
    @Valid
    @NotNull
    EquipamentoRequest equipamento,

    @NotNull
    UUID idQuadro,

    @NotNull
    Float correnteMaxima
) {}
