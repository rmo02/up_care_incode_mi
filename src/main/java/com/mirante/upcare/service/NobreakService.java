package com.mirante.upcare.service;

import java.util.List;
import java.util.UUID;

import com.mirante.upcare.exceptions.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.mirante.upcare.models.Nobreak;
import com.mirante.upcare.repository.NobreakRepository;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class NobreakService {

    private final NobreakRepository nobreakRepository;

    public List<Nobreak> buscarTodos() {
        return nobreakRepository.findAll();
    }

    public Nobreak buscarPorId(UUID id) {
        return nobreakRepository.findById(id).orElseThrow(() -> new NotFoundException("Nobreak não encontrado com o ID: " + id));
    }

    public Nobreak salvar(@Valid Nobreak nobreak) {
        return nobreakRepository.save(nobreak);
    }

    public Nobreak atualizarPorId(UUID idNobreak, @Valid Nobreak nobreakAtualizado){
        var nobreakExistente = buscarPorId(idNobreak);
        BeanUtils.copyProperties(nobreakAtualizado, nobreakExistente, "id");
        return salvar(nobreakExistente);
    }

    public void deletarPorId(UUID idNobreak){
        buscarPorId(idNobreak);
        nobreakRepository.deleteById(idNobreak);
    }
}
