package com.mirante.upcare.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mirante.upcare.dto.request.ArCondionadoRequest;
import com.mirante.upcare.mappers.ArCondicionadoMapper;
import com.mirante.upcare.service.ArCondicionadoService;
import com.mirante.upcare.utils.Pipeline;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("ar-condicionados")
public class ArCondicionadoController {

    private final ArCondicionadoService arCondicionadoService;
    private final ArCondicionadoMapper arCondicionadoMapper;
    
    @PostMapping
    public ResponseEntity<UUID> salvar(@Valid @RequestBody ArCondionadoRequest dto) {
        return (Pipeline
            .from(dto)
            .then(arCondicionadoMapper::toEntity)
            .then(arCondicionadoService::salvar)
            .then(a -> ResponseEntity.status(HttpStatus.CREATED).body(a.getId()))
            .get()
        );
    }
}
