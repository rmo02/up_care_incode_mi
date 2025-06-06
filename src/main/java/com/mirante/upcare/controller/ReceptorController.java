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

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("receptores")
public class ReceptorController {

    private final ReceptorMapper receptorMapper;
    private final ReceptorService receptorService;

    @PostMapping
    public ResponseEntity<Void> salvar(@Valid @RequestBody ReceptorRequest dto) {
        Receptor receptor = receptorMapper.toEntity(dto);
        receptorService.salvar(receptor);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
     public List<ReceptorResponse> buscarTodos() {
        return receptorMapper.toResponseList(receptorService.buscarTodos());
    }

    @GetMapping("{idReceptor}")
    public ReceptorResponse buscarPorId(@PathVariable UUID idReceptor) {
        return receptorMapper.toResponse(receptorService.buscarPorId(idReceptor));
    }

    @PutMapping("{idReceptor}")
    public ResponseEntity<Void> atualizar(@PathVariable UUID idReceptor, @Valid @RequestBody ReceptorRequest dto) {
        Receptor receptor = receptorMapper.toEntity(dto);
        receptorService.atualizarPorId(idReceptor, receptor);
        return  ResponseEntity.noContent().build();
    }

    @DeleteMapping("{idReceptor}")
    public ResponseEntity<Void> deletar( @PathVariable UUID idReceptor) {
        receptorService.deletarPorId(idReceptor);
        return ResponseEntity.noContent().build();
    }

}
