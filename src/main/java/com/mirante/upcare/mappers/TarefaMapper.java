package com.mirante.upcare.mappers;

import com.mirante.upcare.dto.request.TarefaRequest;
import com.mirante.upcare.dto.response.TarefaResponse;
import com.mirante.upcare.models.Tarefa;
import com.mirante.upcare.repository.TarefaRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring", uses = ManutencaoMapper.class)
public abstract class TarefaMapper {

    @Autowired
    private TarefaRepository tarefaRepository;

    @Mapping(target = "id", ignore = true)
    abstract public Tarefa toEntity(TarefaRequest tarefaRequest);


    @Mapping(source = "id", target = "idTarefa")
    abstract public TarefaResponse toResponse(Tarefa tarefa);

    abstract public List<TarefaResponse> toResponseList(List<Tarefa> tarefas);



}
