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
import com.mirante.upcare.dto.request.ReceptorRequest;
import com.mirante.upcare.dto.response.ReceptorResponse;
import com.mirante.upcare.mappers.ReceptorMapper;
import com.mirante.upcare.models.Receptor;
import com.mirante.upcare.service.ReceptorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("receptores")
public class ReceptorController {
    private final ReceptorMapper receptorMapper;
    private final ReceptorService receptorService;

    @Operation(
            summary = "Criar um novo receptor",
            description = "Cria e salva um novo receptor com os dados fornecidos no corpo da requisição. " 
    )
    @PostMapping
    public ResponseEntity<Void> salvar(@Valid @RequestBody ReceptorRequest dto) {
        Receptor receptor = receptorMapper.toEntity(dto);
        receptorService.salvar(receptor);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(
            summary = "Buscar todas as receptores",
            description = "Retorna todas as receptores cadastradas no sistema"
    )
    @GetMapping
     public List<ReceptorResponse> buscarTodos() {
        return receptorMapper.toResponseList(receptorService.buscarTodos());
    }

    @Operation(
            summary = "Buscar receptor por ID",
            description = "Retorna os dados de uma receptor específica com base no ID fornecido"
    )
    @GetMapping("{idReceptor}")
    public ReceptorResponse buscarPorId(
        @Parameter(description = "ID da antena a ser buscada", required = true)
        @PathVariable UUID idReceptor) {
        return receptorMapper.toResponse(receptorService.buscarPorId(idReceptor));
    }

    @Operation(
            summary = "Atualizar receptor por ID",
            description = "Atualiza os dados de uma receptor existente com base no ID e nos dados fornecidos. " 
    )
    @PutMapping("{idReceptor}")
    public ResponseEntity<Void> atualizar(
        @Parameter(description = "ID da antena a ser atualizada", required = true)
        @PathVariable UUID idReceptor, 
        @Parameter(description = "Novos dados da antena", required = true)
        @RequestBody ReceptorRequest dto) {
        Receptor receptor = receptorMapper.toEntity(dto);
        receptorService.atualizarPorId(idReceptor, receptor);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Operation(
            summary = "Excluir receptor por ID",
            description = "Remove um receptor existente com base no ID fornecido"
    )
    @DeleteMapping("{idReceptor}")
    public ResponseEntity<Void> deletar(
        @Parameter(description = "ID da antena a ser excluída", required = true)
        @PathVariable UUID idReceptor) {
        receptorService.deletarPorId(idReceptor);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}