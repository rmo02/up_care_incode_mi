package com.mirante.upcare.service;

import com.mirante.upcare.models.Empresa;
import com.mirante.upcare.repository.EmpresaRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    public Empresa salvar(@Valid Empresa empresa){
        return empresaRepository.save(empresa);
    }
    public List<Empresa> buscarTodos() {
        return empresaRepository.findAll();
    }

}
