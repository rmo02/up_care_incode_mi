package com.mirante.upcare.controller;

import com.mirante.upcare.dto.request.DisjuntorRequest;
import com.mirante.upcare.dto.response.DisjuntorResponse;
import com.mirante.upcare.mappers.DisjuntorMapper;
import com.mirante.upcare.service.DisjuntorService;
import com.mirante.upcare.utils.Pipeline;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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
}