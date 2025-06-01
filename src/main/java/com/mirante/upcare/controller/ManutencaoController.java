package com.mirante.upcare.controller;
import com.mirante.upcare.dto.request.ManutencaoRequest;
import com.mirante.upcare.dto.response.ManutencaoResponse;
import com.mirante.upcare.mappers.ManutencaoMapper;
import com.mirante.upcare.models.Manutencao;
import com.mirante.upcare.service.ManutencaoService;
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
@RequestMapping("Manutencao")
public class ManutencaoController {

    private ManutencaoService manutencaoService;
    private ManutencaoMapper manutencaoMapper;


    @PostMapping
    public ResponseEntity<UUID> salvar(@RequestBody @Valid ManutencaoRequest dto){
        return (Pipeline
                .from(dto)
                .then(manutencaoMapper::toEntity)
                .then(manutencaoService::salvar)
                .then(Manutencao::getId)
                .then(id-> ResponseEntity.status(HttpStatus.CREATED).body(id))
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
    @DeleteMapping("{idManutencao}")
    public ResponseEntity<Void> deletarPorId(@PathVariable UUID idManutencao) {
        manutencaoService.deletarPorId(idManutencao);
        return ResponseEntity.ok().build();
    }

}
