package com.mirante.upcare.controller;

import com.mirante.upcare.dto.request.TelemetriaRequest;
import com.mirante.upcare.dto.response.TelemetriaResponse;
import com.mirante.upcare.mappers.TelemetriaMapper;
import com.mirante.upcare.models.Telemetria;
import com.mirante.upcare.service.TelemetriaService;
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
@RequestMapping("telemetrias")
public class TelemetriaController {
    private TelemetriaMapper telemetriaMapper;
    private TelemetriaService telemetriaService;

    @PostMapping
    public ResponseEntity<UUID> salvar(@Valid @RequestBody TelemetriaRequest dto){
        return (Pipeline
                .from(dto)
                .then(telemetriaMapper::toEntity)
                .then(telemetriaService::salvar)
                .then(Telemetria::getId)
                .then(id->ResponseEntity.status(HttpStatus.CREATED).body(id))
                .get()
        );
    }
    @GetMapping
    public ResponseEntity<List<TelemetriaResponse>> buscarTodos(){
        return (Pipeline
                .from(telemetriaService.buscarTodos())
                .then(telemetriaMapper::toResponseList)
                .then(ResponseEntity::ok)
                .get()
        );
    }
    @GetMapping("{idTelemetria}")
    public ResponseEntity<TelemetriaResponse> buscarPorId(@PathVariable UUID idTelemetria){
        return (Pipeline
                .from(idTelemetria)
                .then(telemetriaService::buscarPorId)
                .then(telemetriaMapper::toResponse)
                .then(ResponseEntity::ok)
                .get()
        );
    }

    @PutMapping("{idTelemetria}")
    public ResponseEntity<UUID>atualizarPorId(@PathVariable UUID idTelemetria, @Valid @RequestBody TelemetriaRequest dto){
        return (Pipeline
                .from(dto)
                .then(telemetriaMapper::toEntity)
                .then(telemetriaAtualizada -> telemetriaService.AtualizarPorId(idTelemetria, telemetriaAtualizada))
                .then(telemetriaAtualizada -> ResponseEntity.ok(telemetriaAtualizada.getId()))
                .get()
        );
    }

    @DeleteMapping("{idTelemetria}")
    public ResponseEntity<Void> excluirPorId(@PathVariable UUID idTelemetria){
        telemetriaService.excluirPorId(idTelemetria);
        return ResponseEntity.ok().build();
    }
}
