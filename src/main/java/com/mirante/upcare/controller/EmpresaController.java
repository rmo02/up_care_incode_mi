package com.mirante.upcare.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mirante.upcare.dto.request.EmpresaRequest;
import com.mirante.upcare.dto.response.EmpresaResponse;
import com.mirante.upcare.mappers.EmpresaMapper;
import com.mirante.upcare.service.EmpresaService;
import com.mirante.upcare.utils.Pipeline;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("Empresa")
public class EmpresaController {

    private final EmpresaService empresaService;
    private final EmpresaMapper empresaMapper;

    @PostMapping
    public ResponseEntity<Object> salvar(@RequestBody @Valid EmpresaRequest dto){
        return (Pipeline
            .from(dto)
            .then(empresaMapper::toEntity)
            .then(empresaService::salvar)
            .then(e -> ResponseEntity.status(HttpStatus.CREATED).build())
            .get()
        );
    }

    @GetMapping
    public ResponseEntity<List<EmpresaResponse>> buscarTodos(){
        return (Pipeline
            .from(empresaService.buscarTodos())
            .then(empresaMapper::toResponseList)
            .then(ResponseEntity::ok)
            .get()
        );
    }

    @GetMapping("idEmpresa")
    public ResponseEntity<EmpresaResponse> buscarPorId(@PathVariable UUID idEmpresa) {
        return (Pipeline
            .from(idEmpresa)
            .then(empresaService::buscarPorId)
            .then(empresaMapper::toResponse)
            .then(ResponseEntity::ok)
            .get()
        );
    }

    @PutMapping("{idEmpresa}")
    public ResponseEntity<Object> atualizarPorId(@PathVariable UUID idEmpresa, @Valid @RequestBody EmpresaRequest dto) {
        return (Pipeline
            .from(dto)
            .then(empresaMapper::toEntity)
            .then(empresaAtualizada -> empresaService.atualiarPorId(idEmpresa, empresaAtualizada))
            .then(e -> ResponseEntity.noContent().build())
            .get()
        );
    }

    @DeleteMapping("{idEmpresa}")
    public ResponseEntity<Object> deletarPorId(@PathVariable UUID idEmpresa) {
        empresaService.deletarPorId(idEmpresa);
        return ResponseEntity.noContent().build();
    }

}
