package com.mirante.upcare.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mirante.upcare.dto.response.EstacaoResponse;
import com.mirante.upcare.mappers.EstacaoMapper;
import com.mirante.upcare.repository.EstacaoRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("estacoes")
public class EstacaoController {

    private final EstacaoRepository estacaoRepository;

    @GetMapping
    public List<EstacaoResponse> buscarTodos() {
        return EstacaoMapper.INSTANCE.toResponseList(
            estacaoRepository.findAll()
        );
    }
    
}
