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

import com.mirante.upcare.dto.request.ManutencaoRequest;
import com.mirante.upcare.dto.response.ManutencaoResponse;
import com.mirante.upcare.mappers.ManutencaoMapper;
import com.mirante.upcare.service.ManutencaoService;
import com.mirante.upcare.utils.Pipeline;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("manutencoes")
public class ManutencaoController {

    private final ManutencaoService manutencaoService;
    private final ManutencaoMapper manutencaoMapper;

    @PostMapping
    public ResponseEntity<Object> salvar(@RequestBody @Valid ManutencaoRequest dto){
        return (Pipeline
            .from(dto)
            .then(manutencaoMapper::toEntity)
            .then(manutencaoService::salvar)
            .then(m -> ResponseEntity.status(HttpStatus.CREATED).build())
            .get()
        );
    }

    @GetMapping
    public ResponseEntity<List<ManutencaoResponse>> buscarTodos(){
        return (Pipeline
            .from(manutencaoService.buscarTodos())
            .then(manutencaoMapper::toResponseList)
            .then(ResponseEntity::ok)
            .get()
        );
    }

    @GetMapping("{idManutencao}")
    public ResponseEntity<ManutencaoResponse> buscarPorId(@PathVariable UUID idManutencao) {
        return (Pipeline
            .from(idManutencao)
            .then(manutencaoService::buscarPorId)
            .then(manutencaoMapper::toResponse)
            .then(ResponseEntity::ok)
            .get()
        );
    }

    @PutMapping("{idManutencao}")
    public ResponseEntity<Object> atualizarPorId(@PathVariable UUID idManutencao, @Valid @RequestBody ManutencaoRequest dto) {
        return (Pipeline
            .from(dto)
            .then(manutencaoMapper::toEntity)
            .then(manutencaoAtualizada -> manutencaoService.atualizarPorId(idManutencao, manutencaoAtualizada))
            .then(m -> ResponseEntity.noContent().build())
            .get()
        );
    }

    @DeleteMapping("{idManutencao}")
    public ResponseEntity<Object> deletarPorId(@PathVariable UUID idManutencao) {
        manutencaoService.deletarPorId(idManutencao);
        return ResponseEntity.noContent().build();
    }

}
