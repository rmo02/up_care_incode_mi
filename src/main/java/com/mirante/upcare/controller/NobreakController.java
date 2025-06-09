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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mirante.upcare.dto.request.NobreakRequest;
import com.mirante.upcare.dto.response.NobreakResponse;
import com.mirante.upcare.mappers.NobreakMapper;
import com.mirante.upcare.service.NobreakService;
import com.mirante.upcare.utils.Pipeline;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("nobreaks")
public class NobreakController {

    private final NobreakService nobreakService;
    private final NobreakMapper nobreakMapper;

    @Operation(
            summary = "Buscar todos os nobreaks",
            description = "Retorna todos os nobreaks cadastrados no sistema"
    )
    @GetMapping
    public ResponseEntity<List<NobreakResponse>> buscarTodos() {
        return Pipeline
                .from(nobreakService.buscarTodos())
                .then(nobreakMapper::toResponseList)
                .then(ResponseEntity::ok)
                .get();
    }

    @Operation(
            summary = "Buscar nobreak por ID",
            description = "Retorna os dados de um nobreak específico com base no ID fornecido"
    )
    @GetMapping("{idNobreak}")
    public ResponseEntity<NobreakResponse> buscarPorId(
            @Parameter(description = "ID do nobreak a ser buscado", required = true)
            @PathVariable UUID idNobreak) {

        return Pipeline
                .from(idNobreak)
                .then(nobreakService::buscarPorId)
                .then(nobreakMapper::toResponse)
                .then(ResponseEntity::ok)
                .get();
    }

    @Operation(
            summary = "Criar um novo nobreak",
            description = "Cria e salva um novo nobreak com os dados fornecidos no corpo da requisição"
    )
    @PostMapping
    public ResponseEntity<Object> salvar(
            @Parameter(description = "Dados do novo nobreak", required = true)
            @Valid @RequestBody NobreakRequest dto) {

        return Pipeline
                .from(dto)
                .then(nobreakMapper::toEntity)
                .then(nobreakService::salvar)
                .then(n -> ResponseEntity.status(HttpStatus.CREATED).build())
                .get();
    }

    @Operation(
            summary = "Atualizar nobreak por ID",
            description = "Atualiza os dados de um nobreak existente com base no ID e nos dados fornecidos"
    )
    @PutMapping("{idNobreak}")
    public ResponseEntity<Object> atualizarPorId(
            @Parameter(description = "ID do nobreak a ser atualizado", required = true)
            @PathVariable UUID idNobreak,
            @Parameter(description = "Novos dados do nobreak", required = true)
            @Valid @RequestBody NobreakRequest dto){

        return (Pipeline
            .from(dto)
            .then(nobreakMapper::toEntity)
            .then(nobreakAtualizado -> nobreakService.atualizarPorId(idNobreak, nobreakAtualizado))
            .then(n -> ResponseEntity.noContent().build())
            .get()
        );
    }

    @Operation(
            summary = "Excluir nobreak por ID",
            description = "Remove um nobreak existente com base no ID fornecido"
    )
    @DeleteMapping("{idNobreak}")
    public ResponseEntity<Object> deletarPorId(
            @Parameter(description = "ID do nobreak a ser excluído", required = true)
            @PathVariable UUID idNobreak){

        nobreakService.deletarPorId(idNobreak);
        return ResponseEntity.noContent().build();
    }
}