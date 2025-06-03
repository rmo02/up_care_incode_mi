package com.mirante.upcare.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.mirante.upcare.dto.request.TarefaRequest;
import com.mirante.upcare.models.Tarefa;

@Mapper(componentModel = "spring", uses = ManutencaoMapper.class)
public interface TarefaMapper {

    // @Autowired
    // private TarefaRepository tarefaRepository;

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "idManutencao", target = "manutencao")
    @Mapping(target = "tarefaEquipamentos", ignore = true)
    Tarefa toEntity(TarefaRequest tarefaRequest);

    

    


    // @Mapping(source = "id", target = "idTarefa")
    // abstract public TarefaResponse toResponse(Tarefa tarefa);

    // abstract public List<TarefaResponse> toResponseList(List<Tarefa> tarefas);



}
