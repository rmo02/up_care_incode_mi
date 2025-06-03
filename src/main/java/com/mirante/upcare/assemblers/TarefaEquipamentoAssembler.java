package com.mirante.upcare.assemblers;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.mirante.upcare.models.Equipamento;
import com.mirante.upcare.models.Tarefa;
import com.mirante.upcare.models.TarefaEquipamento;
import com.mirante.upcare.service.EquipamentoService;
import com.mirante.upcare.utils.Pipeline;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class TarefaEquipamentoAssembler {

    private final EquipamentoService equipamentoService;
    
    public TarefaEquipamento toEntity(Tarefa tarefa, UUID idEquipamento) {
        return (Pipeline
            .from(idEquipamento)
            .then(equipamentoService::buscarPorId)
            .then(equipamento -> toEntity(tarefa, equipamento))
            .get()
        );
    }

    public TarefaEquipamento toEntity(Tarefa tarefa, Equipamento equipamento) {
        return (TarefaEquipamento
            .builder()
            .tarefa(tarefa)
            .equipamento(equipamento)
            .build()
        );
    }

    public List<TarefaEquipamento> toEntityList(Tarefa tarefa, List<UUID> idsEquipamento) {
        return (idsEquipamento.stream()
            .map(idEquipamento -> toEntity(tarefa, idEquipamento))
            .toList()
        );
    }

}
