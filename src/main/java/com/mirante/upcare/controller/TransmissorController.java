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
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@AllArgsConstructor
@RequestMapping("transmissores")
public class TransmissorController {
    private final TransmissorMapper transmissorMapper;
    private final TransmissorService transmissorService;

    @PostMapping
    public ResponseEntity<Void> salvar(@Valid @RequestBody TransmissorRequest dto) {
        Transmissor transmissor = transmissorMapper.toEntity(dto);
        transmissorService.salvar(transmissor);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
     public List<TransmissorResponse> buscarTodos() {
        return transmissorService.buscarTodos();
    }

    @GetMapping("{idTransmissor}")
    public TransmissorResponse buscarPorId(@PathVariable UUID idTransmissor) {
        return transmissorService.buscarPorId(idTransmissor);
    }

    @PutMapping("{idTransmissor}")
    public ResponseEntity<Void> atualizar(@PathVariable UUID idTransmissor, @RequestBody TransmissorRequest dto) {
        Transmissor transmissor = transmissorMapper.toEntity(dto);
        transmissorService.atualizarPorId(idTransmissor, transmissor);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @DeleteMapping("{idTransmissor}")
    public ResponseEntity<Void> deletar( @PathVariable UUID idTransmissor) {
        transmissorService.deletarPorId(idTransmissor);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    
}
