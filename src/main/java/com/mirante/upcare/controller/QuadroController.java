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

import com.mirante.upcare.dto.request.QuadroRequest;
import com.mirante.upcare.dto.response.QuadroResponse;
import com.mirante.upcare.mappers.QuadroMapper;
import com.mirante.upcare.service.QuadroService;
import com.mirante.upcare.utils.Pipeline;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("quadros")
public class QuadroController {

    private final QuadroService quadroService;
    private final QuadroMapper quadroMapper;

    @Operation(
            summary = "Buscar todos os quadros",
            description = "Retorna todos os quadros cadastrados no sistema"
    )
    @GetMapping
    public ResponseEntity<List<QuadroResponse>> buscarTodos() {
        return Pipeline
                .from(quadroService.buscarTodos())
                .then(quadroMapper::toResponseList)
                .then(ResponseEntity::ok)
                .get();
    }

    @Operation(
            summary = "Buscar quadro por ID",
            description = "Retorna os dados de um quadro específico com base no ID fornecido"
    )
    @GetMapping("{idQuadro}")
    public ResponseEntity<QuadroResponse> buscarPorId(
            @Parameter(description = "ID do quadro a ser buscado", required = true)
            @PathVariable UUID idQuadro) {

        return Pipeline
                .from(idQuadro)
                .then(quadroService::buscarPorId)
                .then(quadroMapper::toResponse)
                .then(ResponseEntity::ok)
                .get();
    }

    @Operation(
            summary = "Criar um novo quadro",
            description = "Cria e salva um novo quadro com os dados fornecidos no corpo da requisição"
    )
    @PostMapping
    public ResponseEntity<Object> salvar(
            @Parameter(description = "Dados do novo quadro", required = true)
            @Valid @RequestBody QuadroRequest dto) {

        return Pipeline
                .from(dto)
                .then(quadroMapper::toEntity)
                .then(quadroService::salvar)
                .then(q -> ResponseEntity.status(HttpStatus.CREATED).build())
                .get();
    }

    @Operation(
            summary = "Atualizar quadro por ID",
            description = "Atualiza os dados de um quadro existente com base no ID e nos dados fornecidos"
    )
    @PutMapping("{idQuadro}")
    public ResponseEntity<Object> atualizarPorId(
            @Parameter(description = "ID do quadro a ser atualizado", required = true)
            @PathVariable UUID idQuadro,
            @Parameter(description = "Novos dados do quadro", required = true)
            @Valid @RequestBody QuadroRequest dto) {

        return (Pipeline
            .from(dto)
            .then(quadroMapper::toEntity)
            .then(quadroAtualizado -> quadroService.atualizarPorId(idQuadro, quadroAtualizado))
            .then(q -> ResponseEntity.noContent().build())
            .get()
        );
    }

    @Operation(
            summary = "Excluir quadro por ID",
            description = "Remove um quadro existente com base no ID fornecido"
    )
    @DeleteMapping("{idQuadro}")
    public ResponseEntity<Object> deletarPorId(
            @Parameter(description = "ID do quadro a ser excluído", required = true)
            @PathVariable UUID idQuadro) {

        quadroService.deletarPorId(idQuadro);
        return ResponseEntity.noContent().build();
    }
}