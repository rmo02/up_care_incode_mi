package com.mirante.upcare.mappers;

import java.util.List;
import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.mirante.upcare.dto.request.TarefaRequest;
import com.mirante.upcare.dto.response.TarefaResponse;
import com.mirante.upcare.models.Tarefa;
import com.mirante.upcare.service.TarefaService;

@Mapper(componentModel = "spring", uses = ManutencaoMapper.class)
public abstract class TarefaMapper {

    @Autowired
    private TarefaService tarefaService;

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "idManutencao", target = "manutencao")
    @Mapping(target = "tarefaEquipamentos", ignore = true)
    public abstract Tarefa toEntity(TarefaRequest tarefaRequest);

    public Tarefa toEntity(UUID idTarefa) {
        return tarefaService.buscarPorId(idTarefa);
    }
    
    @Mapping(source = "id", target = "idTarefa")
    @Mapping(target = "equipamentos", ignore = true)
    public abstract TarefaResponse toResponse(Tarefa tarefa);

    public abstract List<TarefaResponse> toResponseList(List<Tarefa> tarefas);
}
