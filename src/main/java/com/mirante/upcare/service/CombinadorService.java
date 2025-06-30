package com.mirante.upcare.service;

import com.mirante.upcare.exceptions.NotFoundException;
import com.mirante.upcare.models.Combinador;
import com.mirante.upcare.repository.CombinadorRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CombinadorService {
    private final CombinadorRepository combinadorRepository;
    public Combinador salvar(@Valid Combinador combinador){return combinadorRepository.save(combinador);}


    public List<Combinador> buscarTodos(){return combinadorRepository.findAll();}
    public Combinador buscarPorId(UUID idCombinador){return combinadorRepository.findById(idCombinador).orElseThrow(
            () -> new NotFoundException("Combinador não encontrado com o ID: " + idCombinador)
    );}
    public Combinador AtualizarPorId(UUID idCombinador, @Valid Combinador combinadorAtualizado){
            Combinador combinadorExistente = buscarPorId(idCombinador);
            BeanUtils.copyProperties(combinadorAtualizado, combinadorExistente, "id");
            return salvar(combinadorExistente);
    }
    public void excluirPorId(UUID idCombinador){
        buscarPorId(idCombinador);
        combinadorRepository.deleteById(idCombinador);
    }
}
