package com.mirante.upcare.controller;

import com.mirante.upcare.dto.request.CaboRequest;
import com.mirante.upcare.dto.response.CaboResponse;
import com.mirante.upcare.mappers.CaboMapper;
import com.mirante.upcare.models.Cabo;
import com.mirante.upcare.service.CaboService;
import com.mirante.upcare.utils.Pipeline;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("cabos")
public class CaboController {
    private CaboMapper caboMapper;
    private CaboService caboService;

    @PostMapping
    public ResponseEntity<UUID> salvar(@Valid @RequestBody CaboRequest dto){
        return (Pipeline
                .from(dto)
                .then(caboMapper::toEntity)
                .then(caboService::salvar)
                .then(Cabo::getId)
                .then(id->ResponseEntity.status(HttpStatus.CREATED).body(id))
                .get()
        );
    }
    @GetMapping
    public ResponseEntity<List<CaboResponse>> buscarTodos(){
        return (Pipeline
                .from(caboService.buscarTodos())
                .then(caboMapper::toResponseList)
                .then(ResponseEntity::ok)
                .get()
                );
    }
    @GetMapping("{idCabo}")
    public ResponseEntity<CaboResponse> buscarPorId(@PathVariable UUID idCabo){
        return (Pipeline
                .from(idCabo)
                .then(caboService::buscarPorId)
                .then(caboMapper::toResponse)
                .then(ResponseEntity::ok)
                .get()
                );
    }

    @PutMapping("{idCabo}")
    public ResponseEntity<UUID>atualizarPorId(@PathVariable UUID idCabo, @Valid @RequestBody CaboRequest dto){
        return (Pipeline
                .from(dto)
                .then(caboMapper::toEntity)
                .then(caboAtualizado -> caboService.AtualizarPorId(idCabo, caboAtualizado))
                .then(caboAtualizado -> ResponseEntity.ok(caboAtualizado.getId()))
                .get()
        );
    }

    @DeleteMapping("{idCabo}")
    public ResponseEntity<Void> excluirPorId(@PathVariable UUID idCabo){
        caboService.excluirPorId(idCabo);
        return ResponseEntity.ok().build();
    }

}
