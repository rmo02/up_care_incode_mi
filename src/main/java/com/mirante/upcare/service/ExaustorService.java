package com.mirante.upcare.service;

import com.mirante.upcare.exceptions.NotFoundException;
import com.mirante.upcare.models.Exaustor;
import com.mirante.upcare.repository.ExaustorRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ExaustorService {
    private final ExaustorRepository exaustorRepository;

    public Exaustor salvar(@Valid Exaustor exaustor) {return exaustorRepository.save(exaustor);}
    public List<Exaustor> buscarTodos(){return exaustorRepository.findAll();}
    public Exaustor buscarPorId(UUID idExaustor){return exaustorRepository.findById(idExaustor).orElseThrow(
            () -> new NotFoundException("Exaustor não encontrado com o ID: " + idExaustor)
    );}
    public Exaustor AtualizarPorId(UUID idExaustor, @Valid Exaustor exaustorAtualizado){
        exaustorAtualizado.setId(idExaustor);
        return salvar(exaustorAtualizado);
    }
    public void excluirPorId(UUID idExaustor){
        buscarPorId(idExaustor);
        exaustorRepository.deleteById(idExaustor);
    }
}
