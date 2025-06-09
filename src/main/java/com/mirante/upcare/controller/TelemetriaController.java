package com.mirante.upcare.controller;

import com.mirante.upcare.dto.request.TelemetriaRequest;
import com.mirante.upcare.dto.response.TelemetriaResponse;
import com.mirante.upcare.mappers.TelemetriaMapper;
import com.mirante.upcare.models.Telemetria;
import com.mirante.upcare.service.TelemetriaService;
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
@RequestMapping("telemetrias")
public class TelemetriaController {
    private TelemetriaMapper telemetriaMapper;
    private TelemetriaService telemetriaService;

    @Operation(
            summary = "Criar uma nova telemetria",
            description = "Cria e salva uma nova telemetria com os dados fornecidos no corpo da requisição"
    )
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
    @Operation(
            summary = "Buscar todas as telemetrias",
            description = "Retorna todas as telemetria cadastradas no sistema"
    )
    @GetMapping
    public ResponseEntity<List<TelemetriaResponse>> buscarTodos(){
        return (Pipeline
                .from(telemetriaService.buscarTodos())
                .then(telemetriaMapper::toResponseList)
                .then(ResponseEntity::ok)
                .get()
        );
    }
    @Operation(
            summary = "Buscar telemetria por ID",
            description = "Retorna os dados de uma telemetria específica com base no ID fornecido"
    )
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

    @Operation(
            summary = "Atualizar telemetria por ID",
            description = "Atualiza os dados de uma telemetria existente com base no ID e nos dados fornecidos"
    )
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

    @Operation(
            summary = "Excluir telemetria por ID",
            description = "Remove uma telemetria existente com base no ID fornecido. "
    )
    @DeleteMapping("{idTelemetria}")
    public ResponseEntity<Void> excluirPorId(@PathVariable UUID idTelemetria){
        telemetriaService.excluirPorId(idTelemetria);
        return ResponseEntity.ok().build();
    }
}
