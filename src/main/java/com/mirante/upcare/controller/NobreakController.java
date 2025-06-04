package com.mirante.upcare.controller;

import com.mirante.upcare.dto.request.NobreakRequest;
import com.mirante.upcare.dto.response.NobreakResponse;
import com.mirante.upcare.mappers.NobreakMapper;
import com.mirante.upcare.service.NobreakService;
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
@RequestMapping("nobreaks")
public class NobreakController {

    private final NobreakService nobreakService;
    private final NobreakMapper nobreakMapper;

    @GetMapping
    public ResponseEntity<List<NobreakResponse>> buscarTodos() {
        return Pipeline
                .from(nobreakService.buscarTodos())
                .then(nobreakMapper::toResponseList)
                .then(ResponseEntity::ok)
                .get();
    }

    @GetMapping("{idNobreak}")
    public ResponseEntity<NobreakResponse> buscarPorId(@PathVariable UUID idNobreak) {
        return Pipeline
                .from(idNobreak)
                .then(nobreakService::buscarPorId)
                .then(nobreakMapper::toResponse)
                .then(ResponseEntity::ok)
                .get();
    }

    @PostMapping
    public ResponseEntity<Object> salvar(@Valid @RequestBody NobreakRequest dto) {
        return Pipeline
                .from(dto)
                .then(nobreakMapper::toEntity)
                .then(nobreakService::salvar)
                .then(n -> ResponseEntity.status(HttpStatus.CREATED).build())
                .get();
    }
}