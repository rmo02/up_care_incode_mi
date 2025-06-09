package com.mirante.upcare.controller;

import com.mirante.upcare.dto.request.CombinadorRequest;
import com.mirante.upcare.dto.response.CombinadorResponse;
import com.mirante.upcare.mappers.CombinadorMapper;
import com.mirante.upcare.models.Combinador;
import com.mirante.upcare.service.CombinadorService;
import com.mirante.upcare.utils.Pipeline;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("combinadors")
public class CombinadorController {
    private CombinadorMapper combinadorMapper;
    private CombinadorService combinadorService;

    @Operation(
            summary = "Criar um novo combinador",
            description = "Cria e salva um novo combinador com os dados fornecidos no corpo da requisição"
    )
    @PostMapping
    public ResponseEntity<UUID> salvar(@Valid @RequestBody CombinadorRequest dto){
        return (Pipeline
                .from(dto)
                .then(combinadorMapper::toEntity)
                .then(combinadorService::salvar)
                .then(Combinador::getId)
                .then(id->ResponseEntity.status(HttpStatus.CREATED).body(id))
                .get()
        );
    }
    @Operation(
            summary = "Buscar todos os combinadores",
            description = "Retorna todos os combinadores cadastrados no sistema"
    )
    @GetMapping
    public ResponseEntity<List<CombinadorResponse>> buscarTodos(){
        return (Pipeline
                .from(combinadorService.buscarTodos())
                .then(combinadorMapper::toResponseList)
                .then(ResponseEntity::ok)
                .get()
        );
    }
    @Operation(
            summary = "Buscar combinador por ID",
            description = "Retorna os dados de um combinador específico com base no ID fornecido"
    )
    @GetMapping("{idCombinador}")
    public ResponseEntity<CombinadorResponse> buscarPorId(@PathVariable UUID idCombinador){
        return (Pipeline
                .from(idCombinador)
                .then(combinadorService::buscarPorId)
                .then(combinadorMapper::toResponse)
                .then(ResponseEntity::ok)
                .get()
        );
    }

    @Operation(
            summary = "Atualizar combinador por ID",
            description = "Atualiza os dados de um combinador existente com base no ID e nos dados fornecidos"
    )
    @PutMapping("{idCombinador}")
    public ResponseEntity<UUID>atualizarPorId(@PathVariable UUID idCombinador, @Valid @RequestBody CombinadorRequest dto){
        return (Pipeline
                .from(dto)
                .then(combinadorMapper::toEntity)
                .then(combinadorAtualizado -> combinadorService.AtualizarPorId(idCombinador, combinadorAtualizado))
                .then(combinadorAtualizado -> ResponseEntity.ok(combinadorAtualizado.getId()))
                .get()
        );
    }

    @Operation(
            summary = "Excluir combinador por ID",
            description = "Remove um combinador existente com base no ID fornecido. "
    )
    @DeleteMapping("{idCombinador}")
    public ResponseEntity<Void> excluirPorId(@PathVariable UUID idCombinador){
        combinadorService.excluirPorId(idCombinador);
        return ResponseEntity.ok().build();
    }
}
