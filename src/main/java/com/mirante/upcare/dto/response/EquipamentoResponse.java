package com.mirante.upcare.dto.response;

import java.util.UUID;

import com.mirante.upcare.models.enums.Categoria;
import com.mirante.upcare.models.enums.StatusTecnico;

public record EquipamentoResponse (
    UUID idEquipamento,
    String marca,
    String codigo,
    String modelo,
    Categoria categoria,
    StatusTecnico status
) {}
