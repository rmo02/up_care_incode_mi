package com.mirante.upcare.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.mirante.upcare.models.Disjuntor;
import com.mirante.upcare.repository.DisjuntorRepository;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

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

    public Disjuntor salvar(@Valid Disjuntor entity) {
        return disjuntorRepository.save(entity);
    }

    public Disjuntor atualizarPorId(UUID idDisjuntor, @Valid Disjuntor disjuntorAtualizado) {
        var disjuntorExistente = buscarPorId(idDisjuntor);
        BeanUtils.copyProperties(disjuntorAtualizado, disjuntorExistente, "id");
        return salvar(disjuntorExistente);
    }

    public void deletarPorId(UUID idDisjuntor) {
        disjuntorRepository.deleteById(idDisjuntor);
    }
}
