package com.mirante.upcare.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.mirante.upcare.dto.response.ParabolicaResponse;
import com.mirante.upcare.mappers.ParabolicaMapper;
import com.mirante.upcare.models.Parabolica;
import com.mirante.upcare.repository.ParabolicaRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ParabolicaService {
    private final ParabolicaRepository parabolicaRepository;
    private final ParabolicaMapper parabolicaMapper;

    public Parabolica salvar(@Valid Parabolica parabolica) {
        return parabolicaRepository.save(parabolica);
    }

    public List<ParabolicaResponse> buscarTodos() {
        return parabolicaMapper.toResponseList (
            parabolicaRepository.findAll()
        );
    }

    public ParabolicaResponse buscarPorId(UUID idParabolica) {
        Parabolica parabolica = parabolicaRepository.findById(idParabolica).orElseThrow();
        return parabolicaMapper.toResponse(parabolica);
    }

    public Parabolica atualizarPorId(UUID idParabolica, @Valid Parabolica parabolicaAtualizada) {
        Parabolica parabolicaExistente = parabolicaRepository.findById(idParabolica).orElseThrow();
        BeanUtils.copyProperties(parabolicaAtualizada, parabolicaExistente, "id");
        return parabolicaRepository.save(parabolicaExistente);
    }
    public void deletarPorId(UUID idParabolica) {
        parabolicaRepository.deleteById(idParabolica);
    }
}
