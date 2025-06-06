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

import com.mirante.upcare.dto.request.SwitchRequest;
import com.mirante.upcare.dto.response.SwitchResponse;
import com.mirante.upcare.mappers.SwitchMapper;
import com.mirante.upcare.service.SwitchService;
import com.mirante.upcare.utils.Pipeline;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

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
    public ResponseEntity<Object> salvar(@Valid @RequestBody SwitchRequest dto) {
        return Pipeline
                .from(dto)
                .then(switchMapper::toEntity)
                .then(switchService::salvar)
                .then(s -> ResponseEntity.status(HttpStatus.CREATED).build())
                .get();
    }

    @PutMapping("{idSwitch}")
    public ResponseEntity<Object> atualizarPorId(@PathVariable UUID idSwitch, @Valid @RequestBody SwitchRequest dto) {
        return (Pipeline
            .from(dto)
            .then(switchMapper::toEntity)
            .then(switchAtualizado -> switchService.atualizarPorId(idSwitch, switchAtualizado))
            .then(q -> ResponseEntity.noContent().build())
            .get()
        );
    }

    @DeleteMapping("{idSwicth}")
    public ResponseEntity<Object> deletarPorId(@PathVariable UUID idSwicth) {
        switchService.deletarPorId(idSwicth);
        return ResponseEntity.noContent().build();
    }
}