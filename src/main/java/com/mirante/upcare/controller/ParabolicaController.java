package com.mirante.upcare.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mirante.upcare.dto.request.ParabolicaRequest;
import com.mirante.upcare.dto.response.ParabolicaResponse;
import com.mirante.upcare.mappers.ParabolicaMapper;
import com.mirante.upcare.models.Parabolica;
import com.mirante.upcare.service.ParabolicaService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
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

@RestController
@AllArgsConstructor
@RequestMapping("parabolicas")
public class ParabolicaController {
    private final ParabolicaMapper parabolicaMapper;
    private final ParabolicaService parabolicaService;

    @Operation(
            summary = "Criar uma nova parabolica",
            description = "Cria e salva uma nova parabolica com os dados fornecidos no corpo da requisição"
    )
    @PostMapping
    public ResponseEntity<Void> salvar(@Valid @RequestBody ParabolicaRequest dto) {
        Parabolica parabolica = parabolicaMapper.toEntity(dto);
        parabolicaService.salvar(parabolica);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(
            summary = "Buscar todas as parabolicas",
            description = "Retorna todas as parabolicas cadastradas no sistema"
    )
    @GetMapping
     public List<ParabolicaResponse> buscarTodos() {
        return  parabolicaMapper.toResponseList(parabolicaService.buscarTodos());
    }

    @Operation(
            summary = "Buscar parabolica por ID",
            description = "Retorna os dados de uma parabolica específica com base no ID fornecido"
    )
    @GetMapping("{idParabolica}")
    public ParabolicaResponse buscarPorId(@PathVariable UUID idParabolica) {
        return parabolicaMapper.toResponse(parabolicaService.buscarPorId(idParabolica));
    }

    @Operation(
            summary = "Atualizar parabolica por ID",
            description = "Atualiza os dados de uma parabolica existente com base no ID e nos dados fornecidos"
    )
    @PutMapping("{idParabolica}")
    public ResponseEntity<Void> atualizar(@PathVariable UUID idParabolica, @RequestBody ParabolicaRequest dto) {
        Parabolica parabolica = parabolicaMapper.toEntity(dto);
        parabolicaService.atualizarPorId(idParabolica, parabolica);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Operation(
            summary = "Excluir parabolica por ID",
            description = "Remove uma parabolica existente com base no ID fornecido" 
    )
    @DeleteMapping("{idParabolica}")
    public ResponseEntity<Void> deletar( @PathVariable UUID idParabolica) {
        parabolicaService.deletarPorId(idParabolica);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    
    
}
