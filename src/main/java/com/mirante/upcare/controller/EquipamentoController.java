package com.mirante.upcare.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mirante.upcare.dto.response.EquipamentoResponse;
import com.mirante.upcare.mappers.EquipamentoMapper;
import com.mirante.upcare.repository.EquipamentoRepository;
import com.mirante.upcare.utils.Pipeline;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("equipamentos")
public class EquipamentoController {

    private final EquipamentoRepository equipamentoRepository;
    private final EquipamentoMapper equipamentoMapper;

    @GetMapping
    public ResponseEntity<List<EquipamentoResponse>> buscarTodos() {
        return (Pipeline
            .from(equipamentoRepository.findAll())
            .then(equipamentoMapper::toResponseList)
            .then(ResponseEntity::ok)
            .get()
        );
    }

}
