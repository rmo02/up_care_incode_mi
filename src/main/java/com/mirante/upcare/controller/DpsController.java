package com.mirante.upcare.controller;

import com.mirante.upcare.dto.request.DpsRequest;
import com.mirante.upcare.dto.response.DpsResponse;
import com.mirante.upcare.mappers.DpsMapper;
import com.mirante.upcare.service.DpsService;
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
    public ResponseEntity<UUID> salvar(@Validated @RequestBody DpsRequest dto) {
        return Pipeline
                .from(dto)
                .then(dpsMapper::toEntity)
                .then(dpsService::salvar)
                .then(d -> ResponseEntity.status(HttpStatus.CREATED).body(d.getId()))
                .get();
    }
}