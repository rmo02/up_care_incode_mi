package com.mirante.upcare.dto.request;

import com.mirante.upcare.models.enums.ClasseDps;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record DpsRequest (
        @NotNull
        EquipamentoRequest equipamento,

        @NotNull
        UUID idQuadro,

        @NotNull
        ClasseDps classeDps
){
}
