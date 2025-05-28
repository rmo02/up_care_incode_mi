package com.mirante.upcare.service;

import org.springframework.stereotype.Service;

import com.mirante.upcare.models.Equipamento;
import com.mirante.upcare.repository.EquipamentoRepository;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EquipamentoService {
    
    private final EquipamentoRepository equipamentoRepository;

    public Equipamento salvar(@Valid Equipamento equipamento){
        return equipamentoRepository.save(equipamento);
    }

}
