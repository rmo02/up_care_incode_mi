package com.mirante.upcare.dto.request;

import com.mirante.upcare.models.enums.TipoManutencao;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record ManutencaoRequest(

        @NotNull
        UUID idEstacao,

        @NotNull
        UUID idTecnico,

        @NotNull
        TipoManutencao manutencao

) {}
