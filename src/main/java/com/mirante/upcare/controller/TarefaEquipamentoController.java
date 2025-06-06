package com.mirante.upcare.controller;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mirante.upcare.dto.request.TarefaEquipamentoRequest;
import com.mirante.upcare.dto.response.TarefaEquipamentoResponse;
import com.mirante.upcare.mappers.TarefaEquipamentoMapper;
import com.mirante.upcare.service.TarefaEquipamentoService;
import com.mirante.upcare.utils.Pipeline;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("tarefas-equipamentos")
public class TarefaEquipamentoController {

    private TarefaEquipamentoService tarefaEquipamentoService;
    private TarefaEquipamentoMapper tarefaEquipamentoMapper;


    @PostMapping
    public ResponseEntity<Object> salvar(@RequestBody @Valid TarefaEquipamentoRequest dto){
        return (Pipeline
            .from(dto)
            .then(tarefaEquipamentoMapper::toEntity)
            .then(tarefaEquipamentoService::salvar)
            .then(te -> ResponseEntity.status(HttpStatus.CREATED).build())
            .get()
        );
    }
    @GetMapping
    public ResponseEntity<List<TarefaEquipamentoResponse>> buscarTodos(){
        return (Pipeline
            .from(tarefaEquipamentoService.buscarTodos())
            .then(tarefaEquipamentoMapper::toResponseList)
            .then(ResponseEntity::ok)
            .get()
        );
    }

    @GetMapping("{idtarefaEquipamento}")
    public ResponseEntity<TarefaEquipamentoResponse> buscarPorId(@PathVariable UUID idtarefaEquipamento) {
        return (Pipeline
            .from(idtarefaEquipamento)
            .then(tarefaEquipamentoService::buscarPorId)
            .then(tarefaEquipamentoMapper::toResponse)
            .then(ResponseEntity::ok)
            .get()
        );
    }
    @DeleteMapping("{idtarefaEquipamento}")
    public ResponseEntity<Object> deletarPorId(@PathVariable UUID idtarefaEquipamento) {
        tarefaEquipamentoService.deletarPorId(idtarefaEquipamento);
        return ResponseEntity.ok().build();
    }



}
