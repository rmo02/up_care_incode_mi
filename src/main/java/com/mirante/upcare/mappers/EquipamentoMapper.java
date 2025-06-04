package com.mirante.upcare.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.mirante.upcare.dto.request.EquipamentoRequest;
import com.mirante.upcare.dto.response.EquipamentoResponse;
import com.mirante.upcare.models.Equipamento;

@Mapper(uses = EstacaoMapper.class, componentModel = "spring")
public interface EquipamentoMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "idEstacao", target = "estacao")
    public abstract Equipamento toEntity(EquipamentoRequest dto);

    @Mapping(source = "id", target = "idEquipamento")
    public abstract EquipamentoResponse toResponse(Equipamento equipamento);

    public abstract List<EquipamentoResponse> toResponseList(List<Equipamento> equipamentos);

}
