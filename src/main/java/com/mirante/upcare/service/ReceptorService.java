package com.mirante.upcare.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.mirante.upcare.exceptions.NotFoundException;
import com.mirante.upcare.models.Receptor;
import com.mirante.upcare.repository.ReceptorRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReceptorService {
    private final ReceptorRepository receptorRepository;

    public Receptor salvar(@Valid Receptor receptor) {
        return receptorRepository.save(receptor);
    }

    public List<Receptor> buscarTodos() {
        return receptorRepository.findAll();

    }

    public Receptor buscarPorId(UUID idReceptor) {
        return receptorRepository.findById(idReceptor).orElseThrow(
            () -> new NotFoundException("Receptor não encontrado com o ID: " + idReceptor)
        );
    }

    public Receptor atualizarPorId(UUID idReceptor, @Valid Receptor receptorAtualizado) {
        Receptor receptorExistente = buscarPorId(idReceptor);
        BeanUtils.copyProperties(receptorAtualizado, receptorExistente, "id");
        return receptorRepository.save(receptorExistente);
    }

    public void deletarPorId(UUID idReceptor) {
        buscarPorId(idReceptor);
        receptorRepository.deleteById(idReceptor);
    }
}
