package com.mirante.upcare.controller;

import com.mirante.upcare.dto.request.DpsRequest;
import com.mirante.upcare.dto.response.DpsResponse;
import com.mirante.upcare.mappers.DpsMapper;
import com.mirante.upcare.service.DpsService;
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
@RequestMapping("dps")
public class DpsController {

    private final DpsService dpsService;
    private final DpsMapper dpsMapper;

    @Operation(
            summary = "Buscar todos os DPS",
            description = "Retorna a lista de todos os DPS cadastrados no sistema"
    )
    @GetMapping
    public ResponseEntity<List<DpsResponse>> buscarTodos() {
        return Pipeline
                .from(dpsService.buscarTodos())
                .then(dpsMapper::toResponseList)
                .then(ResponseEntity::ok)
                .get();
    }

    @Operation(
            summary = "Buscar DPS por ID",
            description = "Retorna os dados de um DPS específico com base no ID fornecido"
    )
    @GetMapping("{idDps}")
    public ResponseEntity<DpsResponse> buscarPorId(
            @Parameter(description = "ID do DPS a ser buscado", required = true)
            @PathVariable UUID idDps) {

        return Pipeline
                .from(idDps)
                .then(dpsService::buscarPorId)
                .then(dpsMapper::toResponse)
                .then(ResponseEntity::ok)
                .get();
    }

    @Operation(
            summary = "Criar um novo DPS",
            description = "Cria e salva um novo DPS com os dados fornecidos no corpo da requisição"
    )
    @PostMapping
    public ResponseEntity<Object> salvar(
            @Parameter(description = "Dados do novo DPS", required = true)
            @Valid @RequestBody DpsRequest dto) {

        return Pipeline
                .from(dto)
                .then(dpsMapper::toEntity)
                .then(dpsService::salvar)
                .then(d -> ResponseEntity.status(HttpStatus.CREATED).build())
                .get();
    }

    @Operation(
            summary = "Atualizar DPS por ID",
            description = "Atualiza os dados de um DPS existente com base no ID e nos dados fornecidos"
    )
    @PutMapping("{idDps}")
    public ResponseEntity<Object> atualizarPorId(
            @Parameter(description = "ID do DPS a ser atualizado", required = true)
            @PathVariable UUID idDps,
            @Parameter(description = "Novos dados do DPS", required = true)
            @Valid @RequestBody DpsRequest dto) {

        return (Pipeline
            .from(dto)
            .then(dpsMapper::toEntity)
            .then(dpsAtualizado -> dpsService.atualizarPorId(idDps, dpsAtualizado))
            .then(q -> ResponseEntity.noContent().build())
            .get()
        );
    }

    @Operation(
            summary = "Excluir DPS por ID",
            description = "Remove um DPS existente com base no ID fornecido"
    )
    @DeleteMapping("{idDps}")
    public ResponseEntity<Object> deletarPorId(
            @Parameter(description = "ID do DPS a ser excluído", required = true)
            @PathVariable UUID idDps) {

        dpsService.deletarPorId(idDps);
        return ResponseEntity.noContent().build();
    }
}