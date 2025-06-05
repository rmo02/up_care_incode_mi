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

import com.mirante.upcare.dto.request.QuadroRequest;
import com.mirante.upcare.dto.response.QuadroResponse;
import com.mirante.upcare.mappers.QuadroMapper;
import com.mirante.upcare.service.QuadroService;
import com.mirante.upcare.utils.Pipeline;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

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
    public ResponseEntity<Object> salvar(@Valid @RequestBody QuadroRequest dto) {
        return Pipeline
                .from(dto)
                .then(quadroMapper::toEntity)
                .then(quadroService::salvar)
                .then(q -> ResponseEntity.status(HttpStatus.CREATED).build())
                .get();
    }

    @PutMapping("{idQuadro}")
    public ResponseEntity<Object> atualizarPorId(@PathVariable UUID idQuadro, @Valid @RequestBody QuadroRequest dto) {
        return (Pipeline
            .from(dto)
            .then(quadroMapper::toEntity)
            .then(quadroAtualizado -> quadroService.atualizarPorId(idQuadro, quadroAtualizado))
            .then(q -> ResponseEntity.noContent().build())
            .get()
        );
    }

    @DeleteMapping("{idQuadro}")
    public ResponseEntity<Object> deletarPorId(@PathVariable UUID idQuadro) {
        quadroService.deletarPorId(idQuadro);
        return ResponseEntity.noContent().build();
    }
}