package com.mirante.upcare.service;

import java.util.List;
import java.util.UUID;

import com.mirante.upcare.exceptions.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.mirante.upcare.models.Dps;
import com.mirante.upcare.repository.DpsRepository;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DpsService {

    private final DpsRepository dpsRepository;

    public List<Dps> buscarTodos() {
        return dpsRepository.findAll();
    }

    public Dps buscarPorId(UUID id) {
        return dpsRepository.findById(id).orElseThrow(() -> new NotFoundException("DPS não encontrado com o ID: " + id));
    }

    public Dps salvar(@Valid Dps entity) {
        return dpsRepository.save(entity);
    }

    public Dps atualizarPorId(UUID idDps, @Valid Dps dpsAtualizado) {
        var dpsExistente = buscarPorId(idDps);
        BeanUtils.copyProperties(dpsAtualizado, dpsExistente, "id");
        return salvar(dpsExistente);
    }

    public void deletarPorId(UUID idDps) {
        dpsRepository.deleteById(idDps);
    }
}
