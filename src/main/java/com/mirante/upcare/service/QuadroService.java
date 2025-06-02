package com.mirante.upcare.service;

import com.mirante.upcare.models.Quadro;
import com.mirante.upcare.repository.QuadroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class QuadroService {

    private final QuadroRepository quadroRepository;

    public List<Quadro> buscarTodos() {
        return quadroRepository.findAll();
    }

    public Quadro buscarPorId(UUID id) {
        return quadroRepository.findById(id).orElseThrow();
    }

    public Quadro salvar(Quadro quadro) {
        return quadroRepository.save(quadro);
    }
}
