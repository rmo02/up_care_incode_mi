package com.mirante.upcare.service;

import com.mirante.upcare.models.Empresa;
import com.mirante.upcare.repository.EmpresaRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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

    public Empresa buscarPorId(UUID idEmpresa) {
        return empresaRepository.findById(idEmpresa).orElseThrow();
    }

    public Empresa atualiarPorId(UUID idEmpresa, @Valid Empresa empresaAtualizada) {
        Empresa empresaExistente = buscarPorId(idEmpresa);
        BeanUtils.copyProperties(empresaAtualizada, empresaExistente, "id");
        return salvar(empresaExistente);
    }

    public void deletarPorId(UUID idEmpresa) {
        empresaRepository.deleteById(idEmpresa);
    }

}
