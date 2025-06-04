package com.mirante.upcare.assemblers;

import java.util.List;

import org.springframework.stereotype.Component;

import com.mirante.upcare.dto.request.TarefaRequest;
import com.mirante.upcare.dto.response.TarefaResponse;
import com.mirante.upcare.mappers.TarefaMapper;
import com.mirante.upcare.models.Tarefa;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class TarefaAssembler {
    
    private final TarefaMapper tarefaMapper;
    private final TarefaEquipamentoAssembler tarefaEquipamentoAssembler;
    
    public Tarefa toEntity(TarefaRequest dto) {

        var tarefa = tarefaMapper.toEntity(dto);
        var tarefaEquipamentos = tarefaEquipamentoAssembler.toEntityList(tarefa, dto.equipamentos());
        tarefa.setTarefaEquipamentos(tarefaEquipamentos);
        
        return tarefa;
    }

    public TarefaResponse toResponse(Tarefa tarefa) {

        var tarefaResponse = tarefaMapper.toResponse(tarefa);
        var equipRespList = tarefaEquipamentoAssembler.toEquipamentoResponseList(tarefa.getTarefaEquipamentos());
        tarefaResponse.setEquipamentos(equipRespList);

        return tarefaResponse;
    }

    public List<TarefaResponse> toResponseList(List<Tarefa> tarefas) {
        return (tarefas.stream()
            .map(this::toResponse)
            .toList()
        );
    }

}
