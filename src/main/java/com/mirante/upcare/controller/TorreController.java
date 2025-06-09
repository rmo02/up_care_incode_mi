package com.mirante.upcare.controller;

import com.mirante.upcare.dto.request.TorreRequest;
import com.mirante.upcare.dto.response.TorreResponse;
import com.mirante.upcare.mappers.TorreMapper;
import com.mirante.upcare.models.Torre;
import com.mirante.upcare.service.TorreService;
import com.mirante.upcare.utils.Pipeline;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("torres")
public class TorreController {
    private TorreMapper torreMapper;
    private TorreService torreService;

    @Operation(
            summary = "Criar uma nova torre",
            description = "Cria e salva uma nova torre com os dados fornecidos no corpo da requisição"
    )
    @PostMapping
    public ResponseEntity<UUID> salvar(@Valid @RequestBody TorreRequest dto){
        return (Pipeline
                .from(dto)
                .then(torreMapper::toEntity)
                .then(torreService::salvar)
                .then(Torre::getId)
                .then(id->ResponseEntity.status(HttpStatus.CREATED).body(id))
                .get()
        );
    }
    @Operation(
            summary = "Buscar todas as torres",
            description = "Retorna todas as torre cadastradas no sistema"
    )
    @GetMapping
    public ResponseEntity<List<TorreResponse>> buscarTodos(){
        return (Pipeline
                .from(torreService.buscarTodos())
                .then(torreMapper::toResponseList)
                .then(ResponseEntity::ok)
                .get()
        );
    }
    @Operation(
            summary = "Buscar torre por ID",
            description = "Retorna os dados de uma torre específica com base no ID fornecido"
    )
    @GetMapping("{idTorre}")
    public ResponseEntity<TorreResponse> buscarPorId(@PathVariable UUID idTorre){
        return (Pipeline
                .from(idTorre)
                .then(torreService::buscarPorId)
                .then(torreMapper::toResponse)
                .then(ResponseEntity::ok)
                .get()
        );
    }

    @Operation(
            summary = "Atualizar torre por ID",
            description = "Atualiza os dados de uma torre existente com base no ID e nos dados fornecidos"
    )
    @PutMapping("{idTorre}")
    public ResponseEntity<UUID>atualizarPorId(@PathVariable UUID idTorre, @Valid @RequestBody TorreRequest dto){
        return (Pipeline
                .from(dto)
                .then(torreMapper::toEntity)
                .then(torreAtualizada -> torreService.AtualizarPorId(idTorre, torreAtualizada))
                .then(torreAtualizada -> ResponseEntity.ok(torreAtualizada.getId()))
                .get()
        );
    }

    @Operation(
            summary = "Excluir torre por ID",
            description = "Remove uma torre existente com base no ID fornecido. "
    )
    @DeleteMapping("{idTorre}")
    public ResponseEntity<Void> excluirPorId(@PathVariable UUID idTorre){
        torreService.excluirPorId(idTorre);
        return ResponseEntity.ok().build();
    }
}
