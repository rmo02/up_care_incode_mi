package com.mirante.upcare.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.mirante.upcare.exceptions.NotFoundException;
import com.mirante.upcare.models.Equipamento;
import com.mirante.upcare.repository.EquipamentoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EquipamentoService {
    
    private final EquipamentoRepository equipamentoRepository;

    public List<Equipamento> buscarTodos() {
        return equipamentoRepository.findAll();
    }

    public Equipamento buscarPorId(UUID idEquipamento) {
        return equipamentoRepository.findById(idEquipamento).orElseThrow(
            () -> new NotFoundException("Equipamento não encontrado com o ID: " + idEquipamento)
        );
    }
}
