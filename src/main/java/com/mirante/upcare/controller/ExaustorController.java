package com.mirante.upcare.controller;

import com.mirante.upcare.dto.request.ExaustorRequest;
import com.mirante.upcare.dto.response.ExaustorResponse;
import com.mirante.upcare.mappers.ExaustorMapper;
import com.mirante.upcare.models.Exaustor;
import com.mirante.upcare.service.ExaustorService;
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
@RequestMapping("exaustores")
public class ExaustorController {

    private ExaustorMapper exaustorMapper;
    private ExaustorService exaustorService;

    @Operation(
            summary = "Criar um novo exaustor",
            description = "Cria e salva um novo exaustor com os dados fornecidos no corpo da requisição"
    )
    @PostMapping
    public ResponseEntity<Object> salvar(@Valid @RequestBody ExaustorRequest dto){
        return (Pipeline
            .from(dto)
            .then(exaustorMapper::toEntity)
            .then(exaustorService::salvar)
            .then(Exaustor::getId)
            .then(id->ResponseEntity.status(HttpStatus.CREATED).build())
            .get()
        );
    }
    @Operation(
            summary = "Buscar todos os exaustores",
            description = "Retorna todos os exaustores cadastrados no sistema"
    )
    @GetMapping
    public ResponseEntity<List<ExaustorResponse>> buscarTodos(){
        return (Pipeline
            .from(exaustorService.buscarTodos())
            .then(exaustorMapper::toResponseList)
            .then(ResponseEntity::ok)
            .get()
        );
    }
    @Operation(
            summary = "Buscar exaustor por ID",
            description = "Retorna os dados de um exaustor específico com base no ID fornecido"
    )
    @GetMapping("{idExaustor}")
    public ResponseEntity<ExaustorResponse> buscarPorId(@PathVariable UUID idExaustor){
        return (Pipeline
            .from(idExaustor)
            .then(exaustorService::buscarPorId)
            .then(exaustorMapper::toResponse)
            .then(ResponseEntity::ok)
            .get()
        );
    }

    @Operation(
            summary = "Atualizar exaustor por ID",
            description = "Atualiza os dados de um exaustor existente com base no ID e nos dados fornecidos"
    )
    @PutMapping("{idExaustor}")
    public ResponseEntity<Object> atualizarPorId(@PathVariable UUID idExaustor, @Valid @RequestBody ExaustorRequest dto){
        return (Pipeline
            .from(dto)
            .then(exaustorMapper::toEntity)
            .then(exaustorAtualizado -> exaustorService.AtualizarPorId(idExaustor, exaustorAtualizado))
            .then(e -> ResponseEntity.noContent().build())
            .get()
        );
    }

    @Operation(
            summary = "Excluir exaustor por ID",
            description = "Remove um exaustor existente com base no ID fornecido. "
    )
    @DeleteMapping("{idExaustor}")
    public ResponseEntity<Object> excluirPorId(@PathVariable UUID idExaustor){
        exaustorService.excluirPorId(idExaustor);
        return ResponseEntity.ok().build();
    }

}
