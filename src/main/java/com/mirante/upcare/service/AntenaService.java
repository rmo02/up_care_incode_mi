package com.mirante.upcare.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.mirante.upcare.exceptions.NotFoundException;
import com.mirante.upcare.models.Antena;
import com.mirante.upcare.repository.AntenaRepository;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AntenaService {
    private final AntenaRepository antenaRepository;

    public Antena salvar(@Valid Antena antena) {
        return antenaRepository.save(antena);
    }

    public List<Antena> buscarTodos() {
        return antenaRepository.findAll();
    }

    public Antena buscarPorId(UUID idAntena) {
        return antenaRepository.findById(idAntena).orElseThrow(
            () -> new NotFoundException("Antena não encontrada com o ID: " + idAntena)
        );
    }

    public Antena atualizarPorId(UUID idAntena, @Valid Antena antenaAtualizado) {
        Antena antenaExistente = antenaRepository.findById(idAntena).orElseThrow();
        BeanUtils.copyProperties(antenaAtualizado, antenaExistente, "id");
        return antenaRepository.save(antenaExistente);
    }
    
    public void deletarPorId(UUID idAntena) {
        antenaRepository.deleteById(idAntena);
    }
}
