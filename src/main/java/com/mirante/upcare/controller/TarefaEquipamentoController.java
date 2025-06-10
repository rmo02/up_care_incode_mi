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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("tarefas-equipamentos")
public class TarefaEquipamentoController {

    private TarefaEquipamentoService tarefaEquipamentoService;
    private TarefaEquipamentoMapper tarefaEquipamentoMapper;


    @Operation(
            summary = "Criar um novo tarefas-equipamentos",
            description = "Cria e salva um novo tarefas-equipamentos com os dados fornecidos no corpo da requisição"
    )
    @PostMapping
    public ResponseEntity<Object> salvar(
            @Parameter(description = "Dados do novo tarefas-equipamentos",required = true)
            @RequestBody @Valid TarefaEquipamentoRequest dto){
        return (Pipeline
            .from(dto)
            .then(tarefaEquipamentoMapper::toEntity)
            .then(tarefaEquipamentoService::salvar)
            .then(te -> ResponseEntity.status(HttpStatus.CREATED).build())
            .get()
        );
    }

    @Operation(
            summary = "Buscar todos os tarefas-equipamentos",
            description = "Retorna todos os tarefas-equipamentos cadastrados no sistema"
    )
    @GetMapping
    public ResponseEntity<List<TarefaEquipamentoResponse>> buscarTodos(){
        return (Pipeline
            .from(tarefaEquipamentoService.buscarTodos())
            .then(tarefaEquipamentoMapper::toResponseList)
            .then(ResponseEntity::ok)
            .get()
        );
    }

    @Operation(
            summary = "Buscar tarefas-equipamentos por ID",
            description = "Retorna os dados de um tarefas-equipamentos específico com base no ID fornecido"
    )
    @GetMapping("{idtarefaEquipamento}")
    public ResponseEntity<TarefaEquipamentoResponse> buscarPorId(
            @Parameter(description = "ID do tarefas-equipamentos a ser buscado",required = true)
            @PathVariable UUID idtarefaEquipamento) {
        return (Pipeline
            .from(idtarefaEquipamento)
            .then(tarefaEquipamentoService::buscarPorId)
            .then(tarefaEquipamentoMapper::toResponse)
            .then(ResponseEntity::ok)
            .get()
        );
    }

    @Operation(
            summary = "Excluir tarefas-equipamentos por ID",
            description = "Remove um tarefas-equipamentos existente com base no ID fornecido"
    )
    @DeleteMapping("{idtarefaEquipamento}")
    public ResponseEntity<Void> deletarPorId(
            @Parameter(description = "ID do tarefas-equipamentos a ser excluido",required = true)
            @PathVariable UUID idtarefaEquipamento) {
        tarefaEquipamentoService.deletarPorId(idtarefaEquipamento);
        return ResponseEntity.ok().build();
    }



}
