package com.mirante.upcare.controller;
import com.mirante.upcare.dto.request.TarefaEquipamentoRequest;
import com.mirante.upcare.dto.response.TarefaEquipamentoResponse;
import com.mirante.upcare.mappers.TarefaEquipamentoMapper;
import com.mirante.upcare.models.TarefaEquipamento;
import com.mirante.upcare.service.TarefaEquipamentoService;
import com.mirante.upcare.utils.Pipeline;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("tarefas-equipamentos")
public class TarefaEquipamentoController {

    private TarefaEquipamentoService tarefaEquipamentoService;
    private TarefaEquipamentoMapper tarefaEquipamentoMapper;


    @PostMapping
    public ResponseEntity<UUID> salvar(@RequestBody @Valid TarefaEquipamentoRequest dto){
        return (Pipeline
                .from(dto)
                .then(tarefaEquipamentoMapper::toEntity)
                .then(tarefaEquipamentoService::salvar)
                .then(TarefaEquipamento::getId)
                .then(id-> ResponseEntity.status(HttpStatus.CREATED).body(id))
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
    public ResponseEntity<Void> deletarPorId(@PathVariable UUID idtarefaEquipamento) {
        tarefaEquipamentoService.deletarPorId(idtarefaEquipamento);
        return ResponseEntity.ok().build();
    }



}
