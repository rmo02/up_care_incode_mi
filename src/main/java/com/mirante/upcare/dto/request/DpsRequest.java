package com.mirante.upcare.dto.request;

import com.mirante.upcare.models.enums.ClasseDps;
import jakarta.validation.constraints.NotNull;

public record DpsRequest (
        @NotNull
        EquipamentoRequest equipamento,

        @NotNull
        QuadroRequest quadro,

        @NotNull
        ClasseDps classeDps
){
}
