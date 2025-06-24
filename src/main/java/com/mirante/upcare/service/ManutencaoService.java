package com.mirante.upcare.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.mirante.upcare.exceptions.NotFoundException;
import com.mirante.upcare.models.Manutencao;
import com.mirante.upcare.repository.ManutencaoRepository;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ManutencaoService {

    private final ManutencaoRepository manutencaoRepository;

    public Manutencao salvar(@Valid Manutencao manutencao){
        return manutencaoRepository.save(manutencao);
    }

    public List<Manutencao> buscarTodos(){
        return manutencaoRepository.findAll();
    }

    public Manutencao buscarPorId(UUID idManutencao) {
        return manutencaoRepository.findById(idManutencao).orElseThrow(
            () -> new NotFoundException("Manutenção não encontrada com ID :" + idManutencao)
        );
    }
    
    public Manutencao atualizarPorId(UUID idManutencao, @Valid Manutencao manutencaoAtualizada) {
        var manutencaoExistente = buscarPorId(idManutencao);
        BeanUtils.copyProperties(manutencaoAtualizada, manutencaoExistente, "id");
        return salvar(manutencaoExistente);
    }

    public void deletarPorId(UUID idManutencao) {
        buscarPorId(idManutencao);
        manutencaoRepository.deleteById(idManutencao);
    }
}
