package com.mirante.upcare.controller;
import com.mirante.upcare.dto.response.TarefaEquipamentoResponse;
import com.mirante.upcare.mappers.TarefaEquipamentoMapper;
import com.mirante.upcare.repository.TarefaEquipamentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("TarefaEquipamento")
public class TarefaEquipamentoController {

    private final TarefaEquipamentoRepository tarefaEquipamentoRepository;

    @GetMapping
    public List<TarefaEquipamentoResponse> buscarTodos(){
        return TarefaEquipamentoMapper.INSTANCE.toResponseList(
                tarefaEquipamentoRepository.findAll()
        );
    }
}
