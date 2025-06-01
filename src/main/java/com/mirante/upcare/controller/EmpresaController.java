package com.mirante.upcare.controller;
import com.mirante.upcare.dto.request.EmpresaRequest;
import com.mirante.upcare.dto.response.EmpresaResponse;
import com.mirante.upcare.mappers.EmpresaMapper;
import com.mirante.upcare.models.Empresa;
import com.mirante.upcare.service.EmpresaService;
import com.mirante.upcare.utils.Pipeline;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("Empresa")
public class EmpresaController {

    private EmpresaService empresaService;
    private EmpresaMapper empresaMapper;

    @PostMapping
    public ResponseEntity<UUID> salvar(@RequestBody @Valid EmpresaRequest dto){
        return (Pipeline
                .from(dto)
                .then(empresaMapper::toEntity)
                .then(empresaService::salvar)
                .then(Empresa::getId)
                .then(id-> ResponseEntity.status(HttpStatus.CREATED).body(id))
                .get()
        );
    }
    public ResponseEntity<List<EmpresaResponse>> buscarTodos(){
        return (Pipeline
                .from(empresaService.buscarTodos())
                .then(empresaMapper::toResponseList)
                .then(ResponseEntity::ok)
                .get()
        );
    }

}
