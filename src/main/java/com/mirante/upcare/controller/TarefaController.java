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

import com.mirante.upcare.assemblers.TarefaAssembler;
import com.mirante.upcare.dto.request.TarefaRequest;
import com.mirante.upcare.dto.response.TarefaResponse;
import com.mirante.upcare.service.TarefaService;
import com.mirante.upcare.utils.Pipeline;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("tarefas")
public class TarefaController {

    private final TarefaService tarefaService;
    private final TarefaAssembler tarefaAssembler;

    @PostMapping
    public ResponseEntity<Object> salvar(@Valid @RequestBody TarefaRequest dto) {
        return (Pipeline
            .from(dto)
            .then(tarefaAssembler::toEntity)
            .then(tarefaService::salvar)
            .then(t -> ResponseEntity.status(HttpStatus.CREATED).build())
            .get()
        );
    }

    @GetMapping
    public ResponseEntity<List<TarefaResponse>> buscarTodos() {
        return (Pipeline
            .from(tarefaService.buscarTodos())
            .then(tarefaAssembler::toResponseList)
            .then(ResponseEntity::ok)
            .get()
        );
    }

    @GetMapping("{idTarefa}")
    public ResponseEntity<TarefaResponse> buscarPorId(@PathVariable UUID idTarefa) {
        return (Pipeline
            .from(idTarefa)
            .then(tarefaService::buscarPorId)
            .then(tarefaAssembler::toResponse)
            .then(ResponseEntity::ok)
            .get()
        );
    }

    @DeleteMapping("{idTarefa}")
    public ResponseEntity<Object> deletarPorId(@PathVariable UUID idTarefa) {
        tarefaService.deletarPorId(idTarefa);
        return ResponseEntity.ok().build();
    }
}
