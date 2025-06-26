package com.mirante.upcare.controller;

import java.util.List;
import java.util.UUID;

import com.mirante.upcare.dto.response.ArCondicionadoResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mirante.upcare.dto.request.ArCondionadoRequest;
import com.mirante.upcare.mappers.ArCondicionadoMapper;
import com.mirante.upcare.service.ArCondicionadoService;
import com.mirante.upcare.utils.Pipeline;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("ar-condicionados")
public class ArCondicionadoController {

    private final ArCondicionadoService arCondicionadoService;
    private final ArCondicionadoMapper arCondicionadoMapper;

    @Operation(
            summary = "Criar um novo ar-condicionado",
            description = "Cria e salva um novo ar-condicionado com os dados fornecidos no corpo da requisição"
    )
    @PostMapping
    public ResponseEntity<Object> salvar(@Valid @RequestBody ArCondionadoRequest dto) {
        return (Pipeline
            .from(dto)
            .then(arCondicionadoMapper::toEntity)
            .then(arCondicionadoService::salvar)
            .then(a -> ResponseEntity.status(HttpStatus.CREATED).build())
            .get()
        );
    }
    @Operation(
            summary = "Buscar todos os ar-condicionados",
            description = "Retorna todos os ar-condicionados cadastrados no sistema"
    )
    @GetMapping
    public ResponseEntity<List<ArCondicionadoResponse>> buscarTodos(){
        return (Pipeline
                .from(arCondicionadoService.buscarTodos())
                .then(arCondicionadoMapper::toResponseList)
                .then(ResponseEntity::ok)
                .get()
        );
    }
    @Operation(
            summary = "Buscar ar-condicionado por ID",
            description = "Retorna os dados de um ar-condicionado específico com base no ID fornecido"
    )
    @GetMapping("{idArCondicionado}")
    public ResponseEntity<ArCondicionadoResponse> buscarPorId(@PathVariable UUID idArCondicionado){
        return (Pipeline
                .from(idArCondicionado)
                .then(arCondicionadoService::buscarPorId)
                .then(arCondicionadoMapper::toResponse)
                .then(ResponseEntity::ok)
                .get()
        );
    }

    @Operation(
            summary = "Atualizar ar-condicionado por ID",
            description = "Atualiza os dados de um ar-condicionado existente com base no ID e nos dados fornecidos"
    )
    @PutMapping("{idArCondicionado}")
    public ResponseEntity<UUID>atualizarPorId(@PathVariable UUID idArCondicionado, @Valid @RequestBody ArCondionadoRequest dto){
        return (Pipeline
                .from(dto)
                .then(arCondicionadoMapper::toEntity)
                .then(arCondicionadoAtualizado -> arCondicionadoService.AtualizarPorId(idArCondicionado, arCondicionadoAtualizado))
                .then(arCondicionadoAtualizado -> ResponseEntity.ok(arCondicionadoAtualizado.getId()))
                .get()
        );
    }

    @Operation(
            summary = "Excluir ar-condicionado por ID",
            description = "Remove um ar-condicionado existente com base no ID fornecido. "
    )
    @DeleteMapping("{idArCondicionado}")
    public ResponseEntity<Void> excluirPorId(@PathVariable UUID idArCondicionado){
        arCondicionadoService.excluirPorId(idArCondicionado);
        return ResponseEntity.ok().build();
    }
}
