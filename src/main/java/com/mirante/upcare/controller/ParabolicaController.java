package com.mirante.upcare.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mirante.upcare.dto.response.ParabolicaResponse;
import com.mirante.upcare.mappers.ParabolicaMapper;
import com.mirante.upcare.repository.ParabolicaRepository;
import lombok.AllArgsConstructor;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@AllArgsConstructor
@RequestMapping("parabolicas")
public class ParabolicaController {
    private final ParabolicaRepository parabolicaRepository;

    @GetMapping("path")
     public List<ParabolicaResponse> buscarTodos() {
        return ParabolicaMapper.INSTANCE.toResponseList (
            parabolicaRepository.findAll()
        );
    }
    
}
