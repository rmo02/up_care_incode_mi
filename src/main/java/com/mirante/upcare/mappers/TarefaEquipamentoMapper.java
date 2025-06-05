package com.mirante.upcare.mappers;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.mirante.upcare.dto.request.TarefaEquipamentoRequest;
import com.mirante.upcare.dto.response.TarefaEquipamentoResponse;
import com.mirante.upcare.models.TarefaEquipamento;

@Mapper(componentModel = "spring", uses = {EquipamentoMapper.class, TarefaMapper.class})
public abstract class TarefaEquipamentoMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "idTarefa", target = "tarefa")
    @Mapping(source = "idEquipamento", target = "equipamento")
    public abstract TarefaEquipamento toEntity(TarefaEquipamentoRequest tarefaEquipamentoRequest);

    @Mapping(source = "id", target = "idTarefaEquipamento")
    public abstract TarefaEquipamentoResponse toResponse(TarefaEquipamento tarefaEquipamento);

    public abstract List<TarefaEquipamentoResponse> toResponseList(List<TarefaEquipamento> tarefaEquipamentos);

}
