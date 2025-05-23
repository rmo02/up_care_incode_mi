package com.mirante.upcare.dto.response;

import java.util.UUID;

import com.mirante.upcare.models.enums.PosicaoAntena;
import com.mirante.upcare.models.enums.TipoAntena;

public record AntenaResponse (
    UUID idAntena,
    EquipamentoResponse equipamento,
    TransmissorResponse transmissor,
    String gain,
    TipoAntena tipo,
    PosicaoAntena posicao,
    Float vr
){}
