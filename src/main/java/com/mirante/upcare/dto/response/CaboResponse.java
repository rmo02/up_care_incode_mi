package com.mirante.upcare.dto.response;

import java.util.UUID;

import com.mirante.upcare.models.enums.TipoCabo;

public record CaboResponse ( 
    UUID idCabo,
    EquipamentoResponse equipamento,
    TipoCabo tipo,
    Float tamanho
) {}
