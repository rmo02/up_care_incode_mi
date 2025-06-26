package com.mirante.upcare.service;

import com.mirante.upcare.exceptions.NotFoundException;
import com.mirante.upcare.models.Cabo;
import com.mirante.upcare.repository.CaboRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CaboService {

    private final CaboRepository caboRepository;

    public Cabo salvar(@Valid Cabo cabo) {return caboRepository.save(cabo);}
    public List<Cabo> buscarTodos(){return caboRepository.findAll();}
    public Cabo buscarPorId(UUID idCabo){return caboRepository.findById(idCabo).orElseThrow(
            () -> new NotFoundException("Cabo não encontrado com o ID: " + idCabo)
    );}
    public Cabo AtualizarPorId(UUID idCabo, @Valid Cabo caboAtualizado){
        caboAtualizado.setId(idCabo);
        return salvar(caboAtualizado);
    }
    public void excluirPorId(UUID idCabo){
        buscarPorId(idCabo);
        caboRepository.deleteById(idCabo);
    }

}
