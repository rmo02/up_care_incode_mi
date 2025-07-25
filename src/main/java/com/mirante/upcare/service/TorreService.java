package com.mirante.upcare.service;

import com.mirante.upcare.exceptions.NotFoundException;
import com.mirante.upcare.models.Torre;
import com.mirante.upcare.repository.TorreRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TorreService {
    private final TorreRepository torreRepository;

    public Torre salvar(@Valid Torre torre) {return torreRepository.save(torre);}
    public List<Torre> buscarTodos(){return torreRepository.findAll();}
    public Torre buscarPorId(UUID idTorre){return torreRepository.findById(idTorre).orElseThrow(
            () -> new NotFoundException("Torre não encontrada com o ID: " + idTorre)
    );}
    public Torre AtualizarPorId(UUID idTorre, @Valid Torre torreAtualizada){
            Torre torreExistente = buscarPorId(idTorre);
            BeanUtils.copyProperties(torreAtualizada, torreExistente, "id");
            return salvar(torreExistente);
    }
    public void excluirPorId(UUID idTorre){
        buscarPorId(idTorre);
        torreRepository.deleteById(idTorre);}
}
