package com.mirante.upcare.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.mirante.upcare.dto.response.EquipamentoResponse;
import com.mirante.upcare.models.Equipamento;

@Mapper(uses = EstacaoMapper.class)
public interface EquipamentoMapper {
    
    EquipamentoMapper INSTANCE = Mappers.getMapper(EquipamentoMapper.class);

    @Mapping(source = "id", target = "idEquipamento")
    EquipamentoResponse toResponse(Equipamento equipamento);

    List<EquipamentoResponse> toResponseList(List<Equipamento> equipamentos);

}
