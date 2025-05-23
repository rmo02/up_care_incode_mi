package com.mirante.upcare.controller;
import com.mirante.upcare.dto.response.EmpresaResponse;
import com.mirante.upcare.mappers.EmpresaMapper;
import com.mirante.upcare.repository.EmpresaRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("Empresa")
public class EmpresaController {

    private final EmpresaRepository empresaRepository;

    @GetMapping
    public List<EmpresaResponse> buscarTodos() {
        return EmpresaMapper.INSTANCE.toResponseList (
                empresaRepository.findAll()
        );
    }

}
