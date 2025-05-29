package com.mirante.upcare.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mirante.upcare.dto.response.EquipamentoResponse;
import com.mirante.upcare.mappers.EquipamentoMapper;
import com.mirante.upcare.service.EquipamentoService;
import com.mirante.upcare.utils.Pipeline;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("equipamentos")
public class EquipamentoController {

    private final EquipamentoService equipamentoService;
    private final EquipamentoMapper equipamentoMapper;

    @GetMapping
    public ResponseEntity<List<EquipamentoResponse>> buscarTodos() {
        return (Pipeline
            .from(equipamentoService.buscarTodos())
            .then(equipamentoMapper::toResponseList)
            .then(ResponseEntity::ok)
            .get()
        );
    }

    @GetMapping("{idEquipamento}")
    public ResponseEntity<EquipamentoResponse> buscarPorId(@PathVariable UUID idEquipamento) {
        return (Pipeline
            .from(idEquipamento)
            .then(equipamentoService::buscarPorId)
            .then(equipamentoMapper::toResponse)
            .then(ResponseEntity::ok)
            .get()
        );
    }

}
