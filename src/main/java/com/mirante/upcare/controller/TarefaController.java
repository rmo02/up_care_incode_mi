package com.mirante.upcare.controller;
import com.mirante.upcare.dto.request.TarefaRequest;
import com.mirante.upcare.dto.response.TarefaResponse;
import com.mirante.upcare.mappers.TarefaMapper;
import com.mirante.upcare.models.Tarefa;
import com.mirante.upcare.service.TarefaService;
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
@RequestMapping("Tarefa")
public class TarefaController {

    private TarefaService tarefaService;
    private TarefaMapper tarefaMapper;

    @PostMapping
    public ResponseEntity<UUID> salvar(@RequestBody @Valid TarefaRequest dto){
        return (Pipeline
                .from(dto)
                .then(tarefaMapper::toEntity)
                .then(tarefaService::salvar)
                .then(Tarefa::getId)
                .then(id-> ResponseEntity.status(HttpStatus.CREATED).body(id))
                .get()
        );
    }
    @GetMapping
    public ResponseEntity<List<TarefaResponse>> buscarTodos(){
        return (Pipeline
                .from(tarefaService.buscarTodos())
                .then(tarefaMapper::toResponseList)
                .then(ResponseEntity::ok)
                .get()
        );
    }

    @GetMapping("{idTarefa}")
    public ResponseEntity<TarefaResponse> buscarPorId(@PathVariable UUID idTarefa) {
        return (Pipeline
                .from(idTarefa)
                .then(tarefaService::buscarPorId)
                .then(tarefaMapper::toResponse)
                .then(ResponseEntity::ok)
                .get()
        );
    }
    @DeleteMapping("{idTarefa}")
    public ResponseEntity<Void> deletarPorId(@PathVariable UUID idTarefa) {
        tarefaService.deletarPorId(idTarefa);
        return ResponseEntity.ok().build();
    }




}
