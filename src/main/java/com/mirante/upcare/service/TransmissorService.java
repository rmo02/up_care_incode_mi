package com.mirante.upcare.service;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.mirante.upcare.exceptions.NotFoundException;
import com.mirante.upcare.models.Transmissor;
import com.mirante.upcare.repository.TransmissorRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TransmissorService {
    private final TransmissorRepository transmissorRepository;

    public Transmissor salvar(@Valid Transmissor transmissor) {
        return transmissorRepository.save(transmissor);
    }

    public List<Transmissor> buscarTodos() {
        return transmissorRepository.findAll();
    }

    public Transmissor buscarPorId(UUID idTransmissor) {
       return transmissorRepository.findById(idTransmissor).orElseThrow(
            () -> new NotFoundException("Transmissor não encontrado com o ID: " + idTransmissor)
       );
        
    }

    public Transmissor atualizarPorId(UUID idTransmissor, @Valid Transmissor transmissorAtualizado) {
        Transmissor transmissorExistente = transmissorRepository.findById(idTransmissor).orElseThrow();
        BeanUtils.copyProperties(transmissorAtualizado, transmissorExistente, "id");
        return transmissorRepository.save(transmissorExistente);
    }
    
    public void deletarPorId(UUID idTransmissor) {
        transmissorRepository.deleteById(idTransmissor);
    }
}
