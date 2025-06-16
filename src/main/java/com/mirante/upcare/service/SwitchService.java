package com.mirante.upcare.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.mirante.upcare.models.Switch;
import com.mirante.upcare.repository.SwitchRepository;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SwitchService {

    private final SwitchRepository switchRepository;

    public List<Switch> buscarTodos() {
        return switchRepository.findAll();
    }

    public Switch buscarPorId(UUID id) {
        return switchRepository.findById(id).orElseThrow();
    }

    public Switch salvar(@Valid Switch entity) {
        return switchRepository.save(entity);
    }

    public Switch atualizarPorId(UUID idSwitch, @Valid Switch switchAtualizado) {
        var switchExistente = buscarPorId(idSwitch);
        BeanUtils.copyProperties(switchAtualizado, switchExistente, "id");
        return salvar(switchExistente);
    }

    public void deletarPorId(UUID idSwitch) {
        switchRepository.deleteById(idSwitch);
    }
}
