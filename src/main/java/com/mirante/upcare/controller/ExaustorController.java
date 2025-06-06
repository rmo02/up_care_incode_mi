package com.mirante.upcare.controller;

import com.mirante.upcare.dto.request.ExaustorRequest;
import com.mirante.upcare.dto.response.ExaustorResponse;
import com.mirante.upcare.mappers.ExaustorMapper;
import com.mirante.upcare.models.Exaustor;
import com.mirante.upcare.service.ExaustorService;
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
@RequestMapping("exaustores")
public class ExaustorController {

    private ExaustorMapper exaustorMapper;
    private ExaustorService exaustorService;

    @PostMapping
    public ResponseEntity<Object> salvar(@Valid @RequestBody ExaustorRequest dto){
        return (Pipeline
            .from(dto)
            .then(exaustorMapper::toEntity)
            .then(exaustorService::salvar)
            .then(Exaustor::getId)
            .then(id->ResponseEntity.status(HttpStatus.CREATED).build())
            .get()
        );
    }
    @GetMapping
    public ResponseEntity<List<ExaustorResponse>> buscarTodos(){
        return (Pipeline
            .from(exaustorService.buscarTodos())
            .then(exaustorMapper::toResponseList)
            .then(ResponseEntity::ok)
            .get()
        );
    }
    @GetMapping("{idExaustor}")
    public ResponseEntity<ExaustorResponse> buscarPorId(@PathVariable UUID idExaustor){
        return (Pipeline
            .from(idExaustor)
            .then(exaustorService::buscarPorId)
            .then(exaustorMapper::toResponse)
            .then(ResponseEntity::ok)
            .get()
        );
    }

    @PutMapping("{idExaustor}")
    public ResponseEntity<Object> atualizarPorId(@PathVariable UUID idExaustor, @Valid @RequestBody ExaustorRequest dto){
        return (Pipeline
            .from(dto)
            .then(exaustorMapper::toEntity)
            .then(exaustorAtualizado -> exaustorService.AtualizarPorId(idExaustor, exaustorAtualizado))
            .then(e -> ResponseEntity.noContent().build())
            .get()
        );
    }

    @DeleteMapping("{idExaustor}")
    public ResponseEntity<Object> excluirPorId(@PathVariable UUID idExaustor){
        exaustorService.excluirPorId(idExaustor);
        return ResponseEntity.ok().build();
    }

}
