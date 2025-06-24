package com.mirante.upcare.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.mirante.upcare.exceptions.NotFoundException;
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
        return estacaoRepository.findById(idEstacao).orElseThrow(
            () -> new NotFoundException("Estação não encontrada com o ID: " + idEstacao)
        );
    }

    public Estacao atualizarPorId(UUID idEstacao, @Valid Estacao estacaoAtualizada) {
        Estacao estacaoExistente = buscarPorId(idEstacao);
        BeanUtils.copyProperties(estacaoAtualizada, estacaoExistente, "id");
        return salvar(estacaoExistente);
    }

    public void excluirPorId(UUID idEstacao) {
        buscarPorId(idEstacao);
        estacaoRepository.deleteById(idEstacao);
    }
}
