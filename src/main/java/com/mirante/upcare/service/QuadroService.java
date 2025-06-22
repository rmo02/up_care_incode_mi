package com.mirante.upcare.service;

import com.mirante.upcare.exceptions.NotFoundException;
import com.mirante.upcare.models.Quadro;
import com.mirante.upcare.repository.QuadroRepository;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class QuadroService {

    private final QuadroRepository quadroRepository;

    public List<Quadro> buscarTodos() {
        return quadroRepository.findAll();
    }

    public Quadro buscarPorId(UUID id) {
        return quadroRepository.findById(id).orElseThrow(() -> new NotFoundException("Quadro não encontrado com o ID: " + id));
    }

    public Quadro salvar(@Valid Quadro quadro) {
        return quadroRepository.save(quadro);
    }

    public Quadro atualizarPorId(UUID idQuadro, @Valid Quadro quadroAtualizado) {
        var quadroExistente = buscarPorId(idQuadro);
        BeanUtils.copyProperties(quadroAtualizado, quadroExistente, "id");
        return salvar(quadroExistente);
    }

    public void deletarPorId(UUID idQuadro) {
        quadroRepository.deleteById(idQuadro);
    }
}
