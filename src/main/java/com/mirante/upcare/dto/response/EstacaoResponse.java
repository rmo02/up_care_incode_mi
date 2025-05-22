package com.mirante.upcare.dto.response;

import java.util.UUID;

import com.mirante.upcare.models.enums.StatusTecnico;

public record EstacaoResponse (
    UUID idEstacao,
    String nome,
    Float latitude,
    Float longitude,
    String endereco,
    String linkGrafana,
    StatusTecnico status
) {}
