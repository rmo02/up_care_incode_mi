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

import com.mirante.upcare.dto.request.CaboRequest;
import com.mirante.upcare.dto.response.CaboResponse;
import com.mirante.upcare.mappers.CaboMapper;
import com.mirante.upcare.models.Cabo;
import com.mirante.upcare.service.CaboService;
import com.mirante.upcare.utils.Pipeline;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("cabos")
public class CaboController {
    
    private CaboMapper caboMapper;
    private CaboService caboService;

    @Operation(
            summary = "Criar um novo cabo",
            description = "Cria e salva um novo cabo com os dados fornecidos no corpo da requisição"
    )
    @PostMapping
    public ResponseEntity<Object> salvar(@Valid @RequestBody CaboRequest dto){
        return (Pipeline
            .from(dto)
            .then(caboMapper::toEntity)
            .then(caboService::salvar)
            .then(Cabo::getId)
            .then(id->ResponseEntity.status(HttpStatus.CREATED).build())
            .get()
        );
    }
    @Operation(
            summary = "Buscar todos os cabos",
            description = "Retorna todos os cabos cadastrados no sistema"
    )
    @GetMapping
    public ResponseEntity<List<CaboResponse>> buscarTodos(){
        return (Pipeline
            .from(caboService.buscarTodos())
            .then(caboMapper::toResponseList)
            .then(ResponseEntity::ok)
            .get()
        );
    }
    @Operation(
            summary = "Buscar cabo por ID",
            description = "Retorna os dados de um cabo específico com base no ID fornecido"
    )
    @GetMapping("{idCabo}")
    public ResponseEntity<CaboResponse> buscarPorId(@PathVariable UUID idCabo){
        return (Pipeline
            .from(idCabo)
            .then(caboService::buscarPorId)
            .then(caboMapper::toResponse)
            .then(ResponseEntity::ok)
            .get()
        );
    }

    @Operation(
            summary = "Atualizar cabo por ID",
            description = "Atualiza os dados de um cabo existente com base no ID e nos dados fornecidos"
    )
    @PutMapping("{idCabo}")
    public ResponseEntity<Object> atualizarPorId(@PathVariable UUID idCabo, @Valid @RequestBody CaboRequest dto){
        return (Pipeline
            .from(dto)
            .then(caboMapper::toEntity)
            .then(caboAtualizado -> caboService.AtualizarPorId(idCabo, caboAtualizado))
            .then(c -> ResponseEntity.noContent().build())
            .get()
        );
    }

    @Operation(
            summary = "Excluir cabo por ID",
            description = "Remove um cabo existente com base no ID fornecido. "
    )
    @DeleteMapping("{idCabo}")
    public ResponseEntity<Void> excluirPorId(@PathVariable UUID idCabo){
        caboService.excluirPorId(idCabo);
        return ResponseEntity.noContent().build();
    }

}
