package com.mirante.upcare.service;

import com.mirante.upcare.models.Manutencao;
import com.mirante.upcare.repository.ManutencaoRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

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
        return manutencaoRepository.findById(idManutencao).orElseThrow();
    }
    public void deletarPorId(UUID idManutencao) {
        manutencaoRepository.deleteById(idManutencao);
    }

}
