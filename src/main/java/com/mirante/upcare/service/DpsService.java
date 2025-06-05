package com.mirante.upcare.service;

import com.mirante.upcare.models.Dps;
import com.mirante.upcare.repository.DpsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class DpsService {

    private final DpsRepository dpsRepository;

    public List<Dps> buscarTodos() {
        return dpsRepository.findAll();
    }

    public Dps buscarPorId(UUID id) {
        return dpsRepository.findById(id).orElseThrow();
    }

    public Dps salvar(Dps entity) {
        return dpsRepository.save(entity);
    }
}
