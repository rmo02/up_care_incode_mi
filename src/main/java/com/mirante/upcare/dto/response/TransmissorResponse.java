package com.mirante.upcare.dto.response;

import java.util.UUID;

public record TransmissorResponse (
    UUID idTransmissor,
    EquipamentoResponse equipamento,
    String programado,
    Float canalFisico,
    Float canalVirtual,
    Float acopladorUm,
    Float acopladorDois
){}
