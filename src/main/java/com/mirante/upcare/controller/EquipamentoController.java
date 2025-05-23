package com.mirante.upcare.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mirante.upcare.dto.response.EquipamentoResponse;
import com.mirante.upcare.mappers.EquipamentoMapper;
import com.mirante.upcare.repository.EquipamentoRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("equipamentos")
public class EquipamentoController {

    private final EquipamentoRepository equipamentoRepository;

    @GetMapping
    public List<EquipamentoResponse> buscarTodos() {
        return EquipamentoMapper.INSTANCE.toResponseList (
            equipamentoRepository.findAll()
        );
    }

}
