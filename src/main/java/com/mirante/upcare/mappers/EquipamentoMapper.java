package com.mirante.upcare.mappers;

import java.util.List;
import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.mirante.upcare.dto.request.EquipamentoRequest;
import com.mirante.upcare.dto.response.EquipamentoResponse;
import com.mirante.upcare.models.Equipamento;
import com.mirante.upcare.service.EquipamentoService;

@Mapper(uses = EstacaoMapper.class, componentModel = "spring")
public abstract class EquipamentoMapper {

    @Autowired
    private EquipamentoService equipamentoService;

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "idEstacao", target = "estacao")
    public abstract Equipamento toEntity(EquipamentoRequest dto);

    public Equipamento toEntity(UUID idEquipamento) {
        return equipamentoService.buscarPorId(idEquipamento);
    }

    @Mapping(source = "id", target = "idEquipamento")
    public abstract EquipamentoResponse toResponse(Equipamento equipamento);

    public abstract List<EquipamentoResponse> toResponseList(List<Equipamento> equipamentos);

}
