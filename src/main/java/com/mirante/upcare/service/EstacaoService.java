package com.mirante.upcare.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.mirante.upcare.models.Estacao;
import com.mirante.upcare.repository.EstacaoRepository;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EstacaoService {
    
    private final EstacaoRepository estacaoRepository;
    
    public Estacao salvar(@Valid Estacao estacao) {
        return estacaoRepository.save(estacao);
    }

    public List<Estacao> buscarTodos() {
        return estacaoRepository.findAll();
    }

    public Estacao buscarPorId(UUID idEstacao) {
        return estacaoRepository.findById(idEstacao).orElseThrow();
    }

    public void excluirPorId(UUID idEstacao) {
        estacaoRepository.deleteById(idEstacao);
    }
}
