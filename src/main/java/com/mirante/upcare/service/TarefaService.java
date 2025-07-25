package com.mirante.upcare.service;

import com.mirante.upcare.exceptions.NotFoundException;
import com.mirante.upcare.models.Tarefa;
import com.mirante.upcare.repository.TarefaRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    public Tarefa salvar(@Valid Tarefa tarefa){
        return tarefaRepository.save(tarefa);
    }

    public List<Tarefa> buscarTodos(){
        return tarefaRepository.findAll();
    }

    public Tarefa buscarPorId(UUID idTarefa){
        return tarefaRepository.findById(idTarefa).orElseThrow(
            () -> new NotFoundException("Tarefa não encontrada com o ID: " + idTarefa)
        );
    }
    
    public void deletarPorId(UUID idTarefa){
        buscarPorId(idTarefa);
        tarefaRepository.deleteById(idTarefa);
    }
}
