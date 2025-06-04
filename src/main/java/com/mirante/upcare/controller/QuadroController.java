package com.mirante.upcare.controller;

import com.mirante.upcare.dto.request.QuadroRequest;
import com.mirante.upcare.dto.response.QuadroResponse;
import com.mirante.upcare.mappers.QuadroMapper;
import com.mirante.upcare.service.QuadroService;
import com.mirante.upcare.utils.Pipeline;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("quadros")
public class QuadroController {

    private final QuadroService quadroService;
    private final QuadroMapper quadroMapper;

    @GetMapping
    public ResponseEntity<List<QuadroResponse>> buscarTodos() {
        return Pipeline
                .from(quadroService.buscarTodos())
                .then(quadroMapper::toResponseList)
                .then(ResponseEntity::ok)
                .get();
    }

    @GetMapping("{idQuadro}")
    public ResponseEntity<QuadroResponse> buscarPorId(@PathVariable UUID idQuadro) {
        return Pipeline
                .from(idQuadro)
                .then(quadroService::buscarPorId)
                .then(quadroMapper::toResponse)
                .then(ResponseEntity::ok)
                .get();
    }

    @PostMapping
    public ResponseEntity<UUID> salvar(@Valid @RequestBody QuadroRequest dto) {
        return Pipeline
                .from(dto)
                .then(quadroMapper::toEntity)
                .then(quadroService::salvar)
                .then(q -> ResponseEntity.status(HttpStatus.CREATED).body(q.getId()))
                .get();
    }
}