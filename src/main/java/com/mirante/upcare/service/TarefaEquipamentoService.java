package com.mirante.upcare.service;

import com.mirante.upcare.exceptions.NotFoundException;
import com.mirante.upcare.models.TarefaEquipamento;
import com.mirante.upcare.repository.TarefaEquipamentoRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TarefaEquipamentoService {
    private final TarefaEquipamentoRepository tarefaEquipamentoRepository;

    public TarefaEquipamento salvar(@Valid TarefaEquipamento tarefaEquipamento) {
        return tarefaEquipamentoRepository.save(tarefaEquipamento);
    }
    public List<TarefaEquipamento> buscarTodos() {
        return tarefaEquipamentoRepository.findAll();
    }
    public TarefaEquipamento buscarPorId(UUID idTarefaEquipamento) {
        return tarefaEquipamentoRepository.findById(idTarefaEquipamento).orElseThrow(
            () -> new NotFoundException("TarefaEquipamento não encontrada com o ID: " + idTarefaEquipamento)
        );
    }
    public void deletarPorId(UUID idTarefaEquipamento) {
        tarefaEquipamentoRepository.deleteById(idTarefaEquipamento);
    }
}
