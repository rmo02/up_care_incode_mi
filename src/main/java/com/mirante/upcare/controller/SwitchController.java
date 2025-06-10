package com.mirante.upcare.controller;

import com.mirante.upcare.dto.request.SwitchRequest;
import com.mirante.upcare.dto.response.SwitchResponse;
import com.mirante.upcare.mappers.SwitchMapper;
import com.mirante.upcare.service.SwitchService;
import com.mirante.upcare.utils.Pipeline;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("switches")
public class SwitchController {

    private final SwitchService switchService;
    private final SwitchMapper switchMapper;

    @Operation(
            summary = "Buscar todos os switches",
            description = "Retorna todos os switches cadastrados no sistema"
    )
    @GetMapping
    public ResponseEntity<List<SwitchResponse>> buscarTodos() {
        return Pipeline
                .from(switchService.buscarTodos())
                .then(switchMapper::toResponseList)
                .then(ResponseEntity::ok)
                .get();
    }

    @Operation(
            summary = "Buscar switch por ID",
            description = "Retorna os dados de um switch específico com base no ID fornecido"
    )
    @GetMapping("{idSwitch}")
    public ResponseEntity<SwitchResponse> buscarPorId(
            @Parameter(description = "ID do switch a ser buscado", required = true)
            @PathVariable UUID idSwitch) {

        return Pipeline
                .from(idSwitch)
                .then(switchService::buscarPorId)
                .then(switchMapper::toResponse)
                .then(ResponseEntity::ok)
                .get();
    }

    @Operation(
            summary = "Criar um novo switch",
            description = "Cria e salva um novo switch com os dados fornecidos no corpo da requisição"
    )
    @PostMapping
    public ResponseEntity<Object> salvar(
            @Parameter(description = "Dados do novo switch", required = true)
            @Valid @RequestBody SwitchRequest dto) {

        return Pipeline
                .from(dto)
                .then(switchMapper::toEntity)
                .then(switchService::salvar)
                .then(s -> ResponseEntity.status(HttpStatus.CREATED).build())
                .get();
    }

    @Operation(
            summary = "Atualizar switch por ID",
            description = "Atualiza os dados de um switch existente com base no ID e nos dados fornecidos"
    )
    @PutMapping("{idSwitch}")
    public ResponseEntity<Object> atualizarPorId(
            @Parameter(description = "ID do switch a ser atualizado", required = true)
            @PathVariable UUID idSwitch,
            @Parameter(description = "Novos dados do switch", required = true)
            @Valid @RequestBody SwitchRequest dto) {

        return (Pipeline
            .from(dto)
            .then(switchMapper::toEntity)
            .then(switchAtualizado -> switchService.atualizarPorId(idSwitch, switchAtualizado))
            .then(q -> ResponseEntity.noContent().build())
            .get()
        );
    }

    @Operation(
            summary = "Excluir switch por ID",
            description = "Remove um switch existente com base no ID fornecido"
    )
    @DeleteMapping("{idSwicth}")
    public ResponseEntity<Object> deletarPorId(
            @Parameter(description = "ID do switch a ser excluído", required = true)
            @PathVariable UUID idSwicth) {

        switchService.deletarPorId(idSwicth);
        return ResponseEntity.noContent().build();
    }
}