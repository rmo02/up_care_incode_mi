package com.mirante.upcare.controller;

import java.util.List;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mirante.upcare.dto.request.TransmissorRequest;
import com.mirante.upcare.dto.response.TransmissorResponse;
import com.mirante.upcare.mappers.TransmissorMapper;
import com.mirante.upcare.models.Transmissor;
import com.mirante.upcare.service.TransmissorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@AllArgsConstructor
@RequestMapping("transmissores")
public class TransmissorController {
    private final TransmissorMapper transmissorMapper;
    private final TransmissorService transmissorService;

    @Operation(
            summary = "Criar um novo transmissor",
            description = "Cria e salva um novo transmissor com os dados fornecidos no corpo da requisição"
    )
    @PostMapping
    public ResponseEntity<Void> salvar(@Valid @RequestBody TransmissorRequest dto) {
        Transmissor transmissor = transmissorMapper.toEntity(dto);
        transmissorService.salvar(transmissor);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(
            summary = "Buscar todos os transmissores",
            description = "Retorna todos os trasnsmissores cadastrados no sistema"
    )
    @GetMapping
     public List<TransmissorResponse> buscarTodos() {
        return transmissorMapper.toResponseList(transmissorService.buscarTodos());
    }

    @Operation(
            summary = "Buscar transmissor por ID",
            description = "Retorna os dados de um transmissor específico com base no ID fornecido"
    )
    @GetMapping("{idTransmissor}")
    public TransmissorResponse buscarPorId(
        @Parameter(description = "ID da antena a ser buscada", required = true)
        @PathVariable UUID idTransmissor) {
        return transmissorMapper.toResponse(transmissorService.buscarPorId(idTransmissor));
    }

    @Operation(
            summary = "Atualizar transmissor por ID",
            description = "Atualiza os dados de um transmissor existente com base no ID e nos dados fornecidos"
    )
    @PutMapping("{idTransmissor}")
    public ResponseEntity<Void> atualizar(
        @Parameter(description = "ID da antena a ser atualizada", required = true)
        @PathVariable UUID idTransmissor, 
        @Parameter(description = "Novos dados da antena", required = true)
        @RequestBody TransmissorRequest dto) {
        Transmissor transmissor = transmissorMapper.toEntity(dto);
        transmissorService.atualizarPorId(idTransmissor, transmissor);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Operation(
            summary = "Excluir transmissor por ID",
            description = "Remove um transmissor existente com base no ID fornecido. " 
    )
    @DeleteMapping("{idTransmissor}")
    public ResponseEntity<Void> deletar(
        @Parameter(description = "ID da antena a ser excluída", required = true)
        @PathVariable UUID idTransmissor) {
        transmissorService.deletarPorId(idTransmissor);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    
}