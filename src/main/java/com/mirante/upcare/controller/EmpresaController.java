package com.mirante.upcare.controller;

import java.util.List;
import java.util.UUID;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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
@RequestMapping("empresas")
public class EmpresaController {

    private final EmpresaService empresaService;
    private final EmpresaMapper empresaMapper;

    @Operation(
            summary = "Criar um novo empresas",
            description = "Cria e salva um novo empresas com os dados fornecidos no corpo da requisição"
    )
    @PostMapping
    public ResponseEntity<Object> salvar(
            @Parameter(description = "Dados do novo empresas", required = true)
            @RequestBody @Valid EmpresaRequest dto){
        return (Pipeline
            .from(dto)
            .then(empresaMapper::toEntity)
            .then(empresaService::salvar)
            .then(e -> ResponseEntity.status(HttpStatus.CREATED).build())
            .get()
        );
    }

    @Operation(
            summary = "Buscar todos os empresas",
            description = "Retorna todos os empresas cadastrados no sistema"
    )
    @GetMapping
    public ResponseEntity<List<EmpresaResponse>> buscarTodos(){
        return (Pipeline
            .from(empresaService.buscarTodos())
            .then(empresaMapper::toResponseList)
            .then(ResponseEntity::ok)
            .get()
        );
    }

    @Operation(
            summary = "Buscar empresas por ID",
            description = "Retorna os dados de um empresas específico com base no ID fornecido"
    )
    @GetMapping("{idEmpresa}")
    public ResponseEntity<EmpresaResponse> buscarPorId(
            @Parameter(description = "ID do nobreak a ser buscado", required = true)
            @PathVariable UUID idEmpresa) {
        return (Pipeline
            .from(idEmpresa)
            .then(empresaService::buscarPorId)
            .then(empresaMapper::toResponse)
            .then(ResponseEntity::ok)
            .get()
        );
    }

    @Operation(
            summary = "Atualizar empresas por ID",
            description = "Atualiza os dados de um empresas existente com base no ID e nos dados fornecidos"
    )
    @PutMapping("{idEmpresa}")
    public ResponseEntity<Object> atualizarPorId(
            @Parameter(description = "ID do empresas a ser atualizado",required = true)
            @PathVariable UUID idEmpresa,
            @Parameter(description = "Novos dados do empresas",required = true)
            @Valid @RequestBody EmpresaRequest dto) {
        return (Pipeline
            .from(dto)
            .then(empresaMapper::toEntity)
            .then(empresaAtualizada -> empresaService.atualiarPorId(idEmpresa, empresaAtualizada))
            .then(e -> ResponseEntity.noContent().build())
            .get()
        );
    }

    @Operation(
            summary = "Excluir empresas por ID",
            description = "Remove um empresas existente com base no ID fornecido"
    )
    @DeleteMapping("{idEmpresa}")
    public ResponseEntity<Object> deletarPorId(
            @Parameter(description = "ID do empresas a ser excluido",required = true)
            @PathVariable UUID idEmpresa) {
        empresaService.deletarPorId(idEmpresa);
        return ResponseEntity.noContent().build();
    }

}
