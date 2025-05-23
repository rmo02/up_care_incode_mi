package com.mirante.upcare.mappers;

import com.mirante.upcare.dto.response.TarefaResponse;
import com.mirante.upcare.models.Tarefa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = ManutencaoMapper.class)
public interface TarefaMapper {

    TarefaMapper INSTANCE = Mappers.getMapper(TarefaMapper.class);

    @Mapping(source = "id", target = "idTarefa")
    TarefaResponse toResponse(Tarefa tarefa);

    List<TarefaResponse> toResponseList(List<Tarefa> tarefas);



}
