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

import com.mirante.upcare.dto.request.AntenaRequest;
import com.mirante.upcare.dto.response.AntenaResponse;
import com.mirante.upcare.mappers.AntenaMapper;
import com.mirante.upcare.models.Antena;
import com.mirante.upcare.service.AntenaService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("antenas")
public class AntenaController {
    private final AntenaMapper antenaMapper;
    private final AntenaService antenaService;

    @PostMapping
    public ResponseEntity<Void> salvar(@Valid @RequestBody AntenaRequest dto) {
        Antena antena = antenaMapper.toEntity(dto);
        antenaService.salvar(antena);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public List<AntenaResponse> buscarTodos() {
        return antenaMapper.toResponseList(antenaService.buscarTodos());
    }

    @GetMapping("{idAntena}")
    public AntenaResponse buscarPorId(@PathVariable UUID idAntena) {
        return antenaMapper.toResponse(antenaService.buscarPorId(idAntena));
    }

    @PutMapping("{idAntena}")
    public ResponseEntity<Void> atualizar(@PathVariable UUID idAntena, @Valid @RequestBody AntenaRequest dto) {
        Antena antena = antenaMapper.toEntity(dto);
        antenaService.atualizarPorId(idAntena, antena);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("{idAntena}")
    public ResponseEntity<Void> deletar( @PathVariable UUID idAntena) {
        antenaService.deletarPorId(idAntena);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    
}
