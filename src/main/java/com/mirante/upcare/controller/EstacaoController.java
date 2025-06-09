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

import com.mirante.upcare.dto.request.EstacaoRequest;
import com.mirante.upcare.dto.response.EstacaoResponse;
import com.mirante.upcare.mappers.EstacaoMapper;
import com.mirante.upcare.service.EstacaoService;
import com.mirante.upcare.utils.Pipeline;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("estacoes")
public class EstacaoController {

    private final EstacaoService estacaoService;
    private final EstacaoMapper estacaoMapper;

    @Operation(
            summary = "Criar um novo estacoes",
            description = "Cria e salva um novo estacoes com os dados fornecidos no corpo da requisição"
    )
    @PostMapping
    public ResponseEntity<Object> salvar(
            @Parameter(description = "Dados do novo estacoes",required = true)
            @RequestBody @Valid EstacaoRequest dto) {
        return (Pipeline
            .from(dto)
            .then(estacaoMapper::toEntity)
            .then(estacaoService::salvar)
            .then(e -> ResponseEntity.status(HttpStatus.CREATED).build())
            .get()
        );
    }

    @Operation(
            summary = "Buscar todos os estacoes",
            description = "Retorna todos os estacoes cadastrados no sistema"
    )
    @GetMapping
    public ResponseEntity<List<EstacaoResponse>> buscarTodos() {
        return (Pipeline
            .from(estacaoService.buscarTodos())
            .then(estacaoMapper::toResponseList)
            .then(ResponseEntity::ok)
            .get()
        );
    }

    @Operation(
            summary = "Buscar estacoes por ID",
            description = "Retorna os dados de um estacoes específico com base no ID fornecido"
    )
    @GetMapping("{idEstacao}")
    public ResponseEntity<EstacaoResponse> buscarPorId(
            @Parameter(description = "ID do estacoes a ser buscado",required = true)
            @PathVariable UUID idEstacao) {
        return (Pipeline
            .from(idEstacao)
            .then(estacaoService::buscarPorId)
            .then(estacaoMapper::toResponse)
            .then(ResponseEntity::ok)
            .get()
        );
    }

    @Operation(
            summary = "Atualizar estacoes por ID",
            description = "Atualiza os dados de um estacoes existente com base no ID e nos dados fornecidos"
    )
    @PutMapping("{idEstacao}")
    public ResponseEntity<Object> atualizarPorId(
            @Parameter(description = "ID do estacoes ser atualizado",required = true)
            @PathVariable UUID idEstacao,
            @Parameter(description = "Novos dados do estacoes",required = true)
            @Valid @RequestBody EstacaoRequest dto) {
        return (Pipeline
            .from(dto)
            .then(estacaoMapper::toEntity)
            .then(estacaoAtualizada -> estacaoService.atualizarPorId(idEstacao, estacaoAtualizada))
            .then(e -> ResponseEntity.noContent().build())
            .get()
        );
    }

    @Operation(
            summary = "Excluir estacoes por ID",
            description = "Remove um usuarios estacoes com base no ID fornecido"
    )
    @DeleteMapping("{idEstacao}")
    public ResponseEntity<Void> excluirPorId(
            @Parameter(description = "ID do estacoes a ser excluido",required = true)
            @PathVariable UUID idEstacao) {
        estacaoService.excluirPorId(idEstacao);
        return ResponseEntity.noContent().build();
    }
    
}
