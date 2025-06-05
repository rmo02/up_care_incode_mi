package com.mirante.upcare.service;

import com.mirante.upcare.models.Nobreak;
import com.mirante.upcare.repository.NobreakRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class NobreakService {

    private final NobreakRepository nobreakRepository;

    public List<Nobreak> buscarTodos() {
        return nobreakRepository.findAll();
    }

    public Nobreak buscarPorId(UUID id) {
        return nobreakRepository.findById(id).orElseThrow();
    }

    public Nobreak salvar(Nobreak nobreak) {
        return nobreakRepository.save(nobreak);
    }
}
