package com.mirante.upcare.controller;

import java.util.List;
import java.util.UUID;

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

import com.mirante.upcare.dto.request.TorreRequest;
import com.mirante.upcare.dto.response.TorreResponse;
import com.mirante.upcare.mappers.TorreMapper;
import com.mirante.upcare.service.TorreService;
import com.mirante.upcare.utils.Pipeline;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

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
    public ResponseEntity<Object> salvar(@Valid @RequestBody TorreRequest dto){
        return (Pipeline
            .from(dto)
            .then(torreMapper::toEntity)
            .then(torreService::salvar)
            .then(t -> ResponseEntity.status(HttpStatus.CREATED).build())
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
    public ResponseEntity<Object> atualizarPorId(@PathVariable UUID idTorre, @Valid @RequestBody TorreRequest dto){
        return (Pipeline
            .from(dto)
            .then(torreMapper::toEntity)
            .then(torreAtualizada -> torreService.AtualizarPorId(idTorre, torreAtualizada))
            .then(t -> ResponseEntity.noContent().build())
            .get()
        );
    }

    @Operation(
            summary = "Excluir torre por ID",
            description = "Remove uma torre existente com base no ID fornecido. "
    )
    @DeleteMapping("{idTorre}")
    public ResponseEntity<Object> excluirPorId(@PathVariable UUID idTorre){
        torreService.excluirPorId(idTorre);
        return ResponseEntity.ok().build();
    }
}
