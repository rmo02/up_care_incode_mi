package com.mirante.upcare.controller;

import com.mirante.upcare.dto.request.DisjuntorRequest;
import com.mirante.upcare.dto.response.DisjuntorResponse;
import com.mirante.upcare.mappers.DisjuntorMapper;
import com.mirante.upcare.service.DisjuntorService;
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
@RequestMapping("disjuntores")
public class DisjuntorController {

    private final DisjuntorService disjuntorService;
    private final DisjuntorMapper disjuntorMapper;

    @Operation(
            summary = "Buscar todos os disjuntores",
            description = "Retorna a lista de todos os disjuntores cadastrados no sistema"
    )
    @GetMapping
    public ResponseEntity<List<DisjuntorResponse>> buscarTodos() {
        return Pipeline
                .from(disjuntorService.buscarTodos())
                .then(disjuntorMapper::toResponseList)
                .then(ResponseEntity::ok)
                .get();
    }

    @Operation(
            summary = "Buscar disjuntor por ID",
            description = "Retorna os dados de um disjuntor específico com base no ID fornecido"
    )
    @GetMapping("{idDisjuntor}")
    public ResponseEntity<DisjuntorResponse> buscarPorId(
            @Parameter(description = "ID do disjuntor a ser buscado", required = true)
            @PathVariable UUID idDisjuntor) {

        return Pipeline
                .from(idDisjuntor)
                .then(disjuntorService::buscarPorId)
                .then(disjuntorMapper::toResponse)
                .then(ResponseEntity::ok)
                .get();
    }

    @Operation(
            summary = "Criar um novo disjuntor",
            description = "Cria e salva um novo disjuntor com os dados fornecidos no corpo da requisição"
    )
    @PostMapping
    public ResponseEntity<UUID> salvar(
            @Parameter(description = "Dados do novo disjuntor", required = true)
            @Valid @RequestBody DisjuntorRequest dto) {

        return Pipeline
                .from(dto)
                .then(disjuntorMapper::toEntity)
                .then(disjuntorService::salvar)
                .then(d -> ResponseEntity.status(HttpStatus.CREATED).body(d.getId()))
                .get();
    }

    @Operation(
            summary = "Atualizar disjuntor por ID",
            description = "Atualiza os dados de um disjuntor existente com base no ID e nos dados fornecidos"
    )
    @PutMapping("{idDisjuntor}")
    public ResponseEntity<Object> atualizarPorId(
            @Parameter(description = "ID do disjuntor a ser atualizado", required = true)
            @PathVariable UUID idDisjuntor,
            @Parameter(description = "Novos dados do disjuntor", required = true)
            @Valid @RequestBody DisjuntorRequest dto) {

        return (Pipeline
            .from(dto)
            .then(disjuntorMapper::toEntity)
            .then(disjuntorAtualizado -> disjuntorService.atualizarPorId(idDisjuntor, disjuntorAtualizado))
            .then(q -> ResponseEntity.noContent().build())
            .get()
        );
    }

    @Operation(
            summary = "Excluir disjuntor por ID",
            description = "Remove um disjuntor existente com base no ID fornecido"
    )
    @DeleteMapping("{idDisjuntor}")
    public ResponseEntity<Object> deletarPorId(
            @Parameter(description = "ID do disjuntor a ser excluído", required = true)
            @PathVariable UUID idDisjuntor) {

        disjuntorService.deletarPorId(idDisjuntor);
        return ResponseEntity.noContent().build();
    }
}