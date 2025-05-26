package com.mirante.upcare.controller;
import com.mirante.upcare.dto.response.ManutencaoResponse;
import com.mirante.upcare.mappers.ManutencaoMapper;
import com.mirante.upcare.repository.ManutencaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("manutencoes")
public class ManutencaoController {

    private final ManutencaoRepository manutencaoRepository;

    @GetMapping
    public List<ManutencaoResponse> buscarTodos() {
        return ManutencaoMapper.INSTANCE.toResponseList(
                manutencaoRepository.findAll()
        );
    }
}
