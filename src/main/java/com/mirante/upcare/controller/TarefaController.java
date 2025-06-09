package com.mirante.upcare.controller;
import java.util.List;
import java.util.UUID;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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

    @Operation(
            summary = "Buscar todos os tarefas",
            description = "Retorna todos os tarefas cadastrados no sistema"
    )
    @PostMapping
    public ResponseEntity<Object> salvar(
            @Parameter(description = "Dados do novo tarefas",required = true)
            @Valid @RequestBody TarefaRequest dto) {
        return (Pipeline
            .from(dto)
            .then(tarefaAssembler::toEntity)
            .then(tarefaService::salvar)
            .then(t -> ResponseEntity.status(HttpStatus.CREATED).build())
            .get()
        );
    }

    @Operation(
            summary = "Buscar todos os tarefas",
            description = "Retorna todos os tarefas cadastrados no sistema"
    )
    @GetMapping
    public ResponseEntity<List<TarefaResponse>> buscarTodos() {
        return (Pipeline
            .from(tarefaService.buscarTodos())
            .then(tarefaAssembler::toResponseList)
            .then(ResponseEntity::ok)
            .get()
        );
    }

    @Operation(
            summary = "Buscar tarefas por ID",
            description = "Retorna os dados de um tarefas específico com base no ID fornecido"
    )
    @GetMapping("{idTarefa}")
    public ResponseEntity<TarefaResponse> buscarPorId(
            @Parameter(description = "ID do tarefas a ser buscado",required = true)
            @PathVariable UUID idTarefa) {
        return (Pipeline
            .from(idTarefa)
            .then(tarefaService::buscarPorId)
            .then(tarefaAssembler::toResponse)
            .then(ResponseEntity::ok)
            .get()
        );
    }

    @Operation(
            summary = "Excluir tarefas por ID",
            description = "Remove um tarefas existente com base no ID fornecido"
    )
    @DeleteMapping("{idTarefa}")
    public ResponseEntity<Void> deletarPorId(
            @Parameter(description = "ID do tarefas a ser exluido",required = true)
            @PathVariable UUID idTarefa) {
        tarefaService.deletarPorId(idTarefa);
        return ResponseEntity.ok().build();
    }
}
