package com.mirante.upcare.service;

import java.util.List;

import org.springframework.stereotype.Service;

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
}
