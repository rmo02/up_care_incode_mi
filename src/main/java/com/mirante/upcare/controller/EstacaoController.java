package com.mirante.upcare.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mirante.upcare.dto.request.EstacaoRequest;
import com.mirante.upcare.dto.response.EstacaoResponse;
import com.mirante.upcare.mappers.EstacaoMapper;
import com.mirante.upcare.models.Estacao;
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

    @PostMapping
    public ResponseEntity<UUID> salvar(@RequestBody @Valid EstacaoRequest dto) {
        return (Pipeline
            .from(dto)
            .then(estacaoMapper::toEntity)
            .then(estacaoService::salvar)
            .then(Estacao::getId)
            .then(id -> ResponseEntity.status(HttpStatus.CREATED).body(id))
            .get()
        );
    }

    @GetMapping
    public ResponseEntity<List<EstacaoResponse>> buscarTodos() {
        return (Pipeline
            .from(estacaoService.buscarTodos())
            .then(estacaoMapper::toResponseList)
            .then(ResponseEntity::ok)
            .get()
        );
    }
    
}
