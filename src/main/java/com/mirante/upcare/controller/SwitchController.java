package com.mirante.upcare.controller;

import com.mirante.upcare.dto.request.SwitchRequest;
import com.mirante.upcare.dto.response.SwitchResponse;
import com.mirante.upcare.mappers.SwitchMapper;
import com.mirante.upcare.service.SwitchService;
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
@RequestMapping("switches")
public class SwitchController {

    private final SwitchService switchService;
    private final SwitchMapper switchMapper;

    @GetMapping
    public ResponseEntity<List<SwitchResponse>> buscarTodos() {
        return Pipeline
                .from(switchService.buscarTodos())
                .then(switchMapper::toResponseList)
                .then(ResponseEntity::ok)
                .get();
    }

    @GetMapping("{idSwitch}")
    public ResponseEntity<SwitchResponse> buscarPorId(@PathVariable UUID idSwitch) {
        return Pipeline
                .from(idSwitch)
                .then(switchService::buscarPorId)
                .then(switchMapper::toResponse)
                .then(ResponseEntity::ok)
                .get();
    }

    @PostMapping
    public ResponseEntity<UUID> salvar(@Validated @RequestBody SwitchRequest dto) {
        return Pipeline
                .from(dto)
                .then(switchMapper::toEntity)
                .then(switchService::salvar)
                .then(s -> ResponseEntity.status(HttpStatus.CREATED).body(s.getId()))
                .get();
    }
}