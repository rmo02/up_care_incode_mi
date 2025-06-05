package com.mirante.upcare.service;

import com.mirante.upcare.models.Disjuntor;
import com.mirante.upcare.repository.DisjuntorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class DisjuntorService {

    private final DisjuntorRepository disjuntorRepository;

    public List<Disjuntor> buscarTodos() {
        return disjuntorRepository.findAll();
    }

    public Disjuntor buscarPorId(UUID id) {
        return disjuntorRepository.findById(id).orElseThrow();
    }

    public Disjuntor salvar(Disjuntor entity) {
        return disjuntorRepository.save(entity);
    }
}
