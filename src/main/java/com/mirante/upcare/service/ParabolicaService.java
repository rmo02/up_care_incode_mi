package com.mirante.upcare.service;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import com.mirante.upcare.exceptions.NotFoundException;
import com.mirante.upcare.models.Parabolica;
import com.mirante.upcare.repository.ParabolicaRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ParabolicaService {
    private final ParabolicaRepository parabolicaRepository;

    public Parabolica salvar(@Valid Parabolica parabolica) {
        return parabolicaRepository.save(parabolica);
    }

    public List<Parabolica> buscarTodos() {
        return parabolicaRepository.findAll();
    }

    public Parabolica buscarPorId(UUID idParabolica) {
        return parabolicaRepository.findById(idParabolica).orElseThrow(
            () -> new NotFoundException("Parabolica não encontrada com o ID: " + idParabolica)
        );
    }

    public Parabolica atualizarPorId(UUID idParabolica, @Valid Parabolica parabolicaAtualizada) {
        Parabolica parabolicaExistente = parabolicaRepository.findById(idParabolica).orElseThrow();
        BeanUtils.copyProperties(parabolicaAtualizada, parabolicaExistente, "id");
        return parabolicaRepository.save(parabolicaExistente);
    }

    public void deletarPorId(UUID idParabolica) {
       try {
            parabolicaRepository.deleteById(idParabolica);
        } catch (DataIntegrityViolationException ex) {
            throw new DataIntegrityViolationException("Não é possível excluir a parabolica: ela está vinculado a outra entidade.");
        } catch (Exception ex) {
            throw ex;
        }
    }
}
