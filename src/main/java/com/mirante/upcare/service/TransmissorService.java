package com.mirante.upcare.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.mirante.upcare.dto.response.TransmissorResponse;
import com.mirante.upcare.mappers.TransmissorMapper;
import com.mirante.upcare.models.Transmissor;
import com.mirante.upcare.repository.TransmissorRepository;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TransmissorService {
    private final TransmissorRepository transmissorRepository;
    private final TransmissorMapper transmissorMapper;

    public Transmissor salvar(@Valid Transmissor transmissor) {
        return transmissorRepository.save(transmissor);
    }

    public List<TransmissorResponse> buscarTodos() {
        return transmissorMapper.toResponseList (
            transmissorRepository.findAll()
        );
    }

    public TransmissorResponse buscarPorId(UUID idTransmissor) {
        Transmissor transmissor = transmissorRepository.findById(idTransmissor).orElseThrow();
        return transmissorMapper.toResponse(transmissor);
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
