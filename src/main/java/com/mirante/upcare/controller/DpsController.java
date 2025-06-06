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

import com.mirante.upcare.dto.request.DpsRequest;
import com.mirante.upcare.dto.response.DpsResponse;
import com.mirante.upcare.mappers.DpsMapper;
import com.mirante.upcare.service.DpsService;
import com.mirante.upcare.utils.Pipeline;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("dps")
public class DpsController {

    private final DpsService dpsService;
    private final DpsMapper dpsMapper;

    @GetMapping
    public ResponseEntity<List<DpsResponse>> buscarTodos() {
        return Pipeline
                .from(dpsService.buscarTodos())
                .then(dpsMapper::toResponseList)
                .then(ResponseEntity::ok)
                .get();
    }

    @GetMapping("{idDps}")
    public ResponseEntity<DpsResponse> buscarPorId(@PathVariable UUID idDps) {
        return Pipeline
                .from(idDps)
                .then(dpsService::buscarPorId)
                .then(dpsMapper::toResponse)
                .then(ResponseEntity::ok)
                .get();
    }

    @PostMapping
    public ResponseEntity<Object> salvar(@Valid @RequestBody DpsRequest dto) {
        return Pipeline
                .from(dto)
                .then(dpsMapper::toEntity)
                .then(dpsService::salvar)
                .then(d -> ResponseEntity.status(HttpStatus.CREATED).build())
                .get();
    }

    @PutMapping("{idDps}")
    public ResponseEntity<Object> atualizarPorId(@PathVariable UUID idDps, @Valid @RequestBody DpsRequest dto) {
        return (Pipeline
            .from(dto)
            .then(dpsMapper::toEntity)
            .then(dpsAtualizado -> dpsService.atualizarPorId(idDps, dpsAtualizado))
            .then(q -> ResponseEntity.noContent().build())
            .get()
        );
    }

    @DeleteMapping("{idDps}")
    public ResponseEntity<Object> deletarPorId(@PathVariable UUID idDps) {
        dpsService.deletarPorId(idDps);
        return ResponseEntity.noContent().build();
    }
}