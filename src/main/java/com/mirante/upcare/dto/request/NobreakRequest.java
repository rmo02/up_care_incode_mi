package com.mirante.upcare.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record NobreakRequest(
    @Valid
    @NotNull
    EquipamentoRequest equipamento,

    @NotNull
    UUID idQuadro,

    @NotNull
    Integer tensaoEntrada,

    @NotNull
    Integer tensaoSaida
) {}
