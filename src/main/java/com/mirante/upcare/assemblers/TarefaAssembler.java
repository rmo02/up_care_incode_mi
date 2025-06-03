package com.mirante.upcare.assemblers;

import org.springframework.stereotype.Component;

import com.mirante.upcare.dto.request.TarefaRequest;
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

}
