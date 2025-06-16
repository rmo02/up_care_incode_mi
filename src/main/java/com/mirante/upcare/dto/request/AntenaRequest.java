package com.mirante.upcare.dto.request;

import java.util.UUID;

import com.mirante.upcare.models.enums.PosicaoAntena;
import com.mirante.upcare.models.enums.TipoAntena;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AntenaRequest (
    @Valid
    @NotNull
    EquipamentoRequest equipamento,

    @NotNull
    UUID idTransmissor,

    @NotBlank
    String gain,

    @NotNull
    TipoAntena tipo,

    @NotNull
    PosicaoAntena posicao,
  
    @NotNull
    Float vr
    
){}
 

