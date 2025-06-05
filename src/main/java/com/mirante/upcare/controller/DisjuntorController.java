package com.mirante.upcare.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mirante.upcare.dto.request.DisjuntorRequest;
import com.mirante.upcare.dto.response.DisjuntorResponse;
import com.mirante.upcare.mappers.DisjuntorMapper;
import com.mirante.upcare.service.DisjuntorService;
import com.mirante.upcare.utils.Pipeline;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("disjuntores")
public class DisjuntorController {

    private final DisjuntorService disjuntorService;
    private final DisjuntorMapper disjuntorMapper;

    @GetMapping
    public ResponseEntity<List<DisjuntorResponse>> buscarTodos() {
        return Pipeline
                .from(disjuntorService.buscarTodos())
                .then(disjuntorMapper::toResponseList)
                .then(ResponseEntity::ok)
                .get();
    }

    @GetMapping("{idDisjuntor}")
    public ResponseEntity<DisjuntorResponse> buscarPorId(@PathVariable UUID idDisjuntor) {
        return Pipeline
                .from(idDisjuntor)
                .then(disjuntorService::buscarPorId)
                .then(disjuntorMapper::toResponse)
                .then(ResponseEntity::ok)
                .get();
    }

    @PostMapping
    public ResponseEntity<UUID> salvar(@Validated @RequestBody DisjuntorRequest dto) {
        return Pipeline
                .from(dto)
                .then(disjuntorMapper::toEntity)
                .then(disjuntorService::salvar)
                .then(d -> ResponseEntity.status(HttpStatus.CREATED).body(d.getId()))
                .get();
    }

    @PutMapping("{idDisjuntor}")
    public ResponseEntity<Object> atualizarPorId(@PathVariable UUID idDisjuntor, @Valid @RequestBody DisjuntorRequest dto) {
        return (Pipeline
            .from(dto)
            .then(disjuntorMapper::toEntity)
            .then(disjuntorAtualizado -> disjuntorService.atualizarPorId(idDisjuntor, disjuntorAtualizado))
            .then(q -> ResponseEntity.noContent().build())
            .get()
        );
    }

    @DeleteMapping("{idDisjuntor}")
    public ResponseEntity<Object> deletarPorId(@PathVariable UUID idDisjuntor) {
        disjuntorService.deletarPorId(idDisjuntor);
        return ResponseEntity.noContent().build();
    }
}