package com.mirante.upcare.service;

import com.mirante.upcare.models.Switch;
import com.mirante.upcare.repository.SwitchRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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

    public Switch salvar(Switch entity) {
        return switchRepository.save(entity);
    }
}
