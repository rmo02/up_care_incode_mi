package com.mirante.upcare.dto.response;

import java.util.UUID;

import com.mirante.upcare.models.enums.TipoManutencao;

public record ManutencaoResponse (
     UUID idManutencao,
     EstacaoResponse estacao,
     UsuarioResponse tecnico,
     TipoManutencao tipo
){}
