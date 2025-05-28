package com.mirante.upcare.service;

import org.springframework.stereotype.Service;

import com.mirante.upcare.models.ArCondicionado;
import com.mirante.upcare.repository.ArCondicionadoRepository;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ArCondicionadoService {
    
    private final ArCondicionadoRepository arCondicionadoRepository;

    public ArCondicionado salvar(@Valid ArCondicionado arCondicionado) {
        return arCondicionadoRepository.save(arCondicionado);
    }
}
