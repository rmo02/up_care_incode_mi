package com.mirante.upcare.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import com.mirante.upcare.models.Receptor;
import com.mirante.upcare.repository.ReceptorRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReceptorService {
    private final ReceptorRepository receptorRepository;

    public Receptor salvar(@Valid Receptor Receptor) {
        return receptorRepository.save(Receptor);
    }

    public List<Receptor> buscarTodos() {
        return receptorRepository.findAll();
    }

    public Receptor buscarPorId(UUID idReceptor) {
        return receptorRepository.findById(idReceptor).orElseThrow();
    }

    public void deletarPorId(UUID idReceptor) {
        receptorRepository.deleteById(idReceptor);
    }
}
