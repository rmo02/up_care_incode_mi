package com.mirante.upcare.service;

import org.springframework.stereotype.Service;
import com.mirante.upcare.models.ArCondicionado;
import com.mirante.upcare.repository.ArCondicionadoRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ArCondicionadoService {
    
    private final ArCondicionadoRepository arCondicionadoRepository;

    public ArCondicionado salvar(@Valid ArCondicionado arCondicionado) {return arCondicionadoRepository.save(arCondicionado);}
    public List<ArCondicionado> buscarTodos(){return arCondicionadoRepository.findAll();}
    public ArCondicionado buscarPorId(UUID idArCondicionado){return arCondicionadoRepository.findById(idArCondicionado).orElseThrow();}
    public ArCondicionado AtualizarPorId(UUID idArCondicionado, @Valid ArCondicionado arCondicionadoAtualizado){
            arCondicionadoAtualizado.setId(idArCondicionado);
            return salvar(arCondicionadoAtualizado);
        }
    public void excluirPorId(UUID idArCondicionado){arCondicionadoRepository.deleteById(idArCondicionado);}
    }
