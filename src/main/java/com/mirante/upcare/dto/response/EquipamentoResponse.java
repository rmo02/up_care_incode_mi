package com.mirante.upcare.dto.response;

import java.util.UUID;

import com.mirante.upcare.models.enums.Categoria;
import com.mirante.upcare.models.enums.StatusTecnico;
import com.mirante.upcare.models.enums.TipoEquipamento;

public record EquipamentoResponse (
    UUID idEquipamento,
    EstacaoResponse estacao,
    String marca,
    String codigo,
    String modelo,
    Categoria categoria,
    StatusTecnico status,
    TipoEquipamento tipo

) {}
