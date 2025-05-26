package com.mirante.upcare.controller;
import com.mirante.upcare.dto.response.TarefaResponse;
import com.mirante.upcare.mappers.TarefaMapper;
import com.mirante.upcare.repository.TarefaRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("Tarefa")
public class TarefaController {

    private final TarefaRepository tarefaRepository;

    @GetMapping
    public List<TarefaResponse> buscarTodos() {
        return TarefaMapper.INSTANCE.toResponseList(
                tarefaRepository.findAll()
        );
    }
}
