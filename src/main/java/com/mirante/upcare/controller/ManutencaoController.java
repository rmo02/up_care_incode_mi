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

import com.mirante.upcare.dto.request.ManutencaoRequest;
import com.mirante.upcare.dto.response.ManutencaoResponse;
import com.mirante.upcare.mappers.ManutencaoMapper;
import com.mirante.upcare.service.ManutencaoService;
import com.mirante.upcare.utils.Pipeline;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("manutencoes")
public class ManutencaoController {

    private final ManutencaoService manutencaoService;
    private final ManutencaoMapper manutencaoMapper;

    @Operation(
            summary = "Criar um novo manutencoes",
            description = "Cria e salva um novo manutencoes com os dados fornecidos no corpo da requisição"
    )
    @PostMapping
    public ResponseEntity<Object> salvar(
            @Parameter(description = "Dados do novo manutencoes", required = true)
            @RequestBody @Valid ManutencaoRequest dto){
        return (Pipeline
            .from(dto)
            .then(manutencaoMapper::toEntity)
            .then(manutencaoService::salvar)
            .then(m -> ResponseEntity.status(HttpStatus.CREATED).build())
            .get()
        );
    }

    @Operation(
            summary = "Buscar todos os manutencoes",
            description = "Retorna todos os manutencoes cadastrados no sistema"
    )
    @GetMapping
    public ResponseEntity<List<ManutencaoResponse>> buscarTodos(){
        return (Pipeline
            .from(manutencaoService.buscarTodos())
            .then(manutencaoMapper::toResponseList)
            .then(ResponseEntity::ok)
            .get()
        );
    }

    @Operation(
            summary = "Buscar manutencoes por ID",
            description = "Retorna os dados de um manutencoes específico com base no ID fornecido"
    )
    @GetMapping("{idManutencao}")
    public ResponseEntity<ManutencaoResponse> buscarPorId(
            @Parameter(description = "ID do nobreak a ser buscado", required = true)
            @PathVariable UUID idManutencao) {
        return (Pipeline
            .from(idManutencao)
            .then(manutencaoService::buscarPorId)
            .then(manutencaoMapper::toResponse)
            .then(ResponseEntity::ok)
            .get()
        );
    }

    @Operation(
            summary = "Atualizar manutencoes por ID",
            description = "Atualiza os dados de um manutencoes existente com base no ID e nos dados fornecidos"
    )
    @PutMapping("{idManutencao}")
    public ResponseEntity<Object> atualizarPorId(
            @Parameter(description = "ID do manutencoes a ser atualizado",required = true)
            @PathVariable UUID idManutencao,
            @Parameter(description = "Novos dados do manutencoes",required = true)
            @Valid @RequestBody ManutencaoRequest dto) {
        return (Pipeline
            .from(dto)
            .then(manutencaoMapper::toEntity)
            .then(manutencaoAtualizada -> manutencaoService.atualizarPorId(idManutencao, manutencaoAtualizada))
            .then(m -> ResponseEntity.noContent().build())
            .get()
        );
    }

    @Operation(
            summary = "Excluir manutencoes por ID",
            description = "Remove um manutencoes existente com base no ID fornecido"
    )
    @DeleteMapping("{idManutencao}")
    public ResponseEntity<Object> deletarPorId(
            @Parameter(description = "ID do manutencoes a ser excluido",required = true)
            @PathVariable UUID idManutencao) {
        manutencaoService.deletarPorId(idManutencao);
        return ResponseEntity.noContent().build();
    }

}
