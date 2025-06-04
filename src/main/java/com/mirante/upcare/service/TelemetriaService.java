package com.mirante.upcare.service;

import com.mirante.upcare.models.Telemetria;
import com.mirante.upcare.repository.TelemetriaRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TelemetriaService {
    private final TelemetriaRepository telemetriaRepository;

    public Telemetria salvar(@Valid Telemetria telemetria) {return telemetriaRepository.save(telemetria);}
    public List<Telemetria> buscarTodos(){return telemetriaRepository.findAll();}
    public Telemetria buscarPorId(UUID idTelemetria){return telemetriaRepository.findById(idTelemetria).orElseThrow();}
    public Telemetria AtualizarPorId(UUID idTelemetria, Telemetria telemetriaAtualizada){
        telemetriaAtualizada.setId(idTelemetria);
        return salvar(telemetriaAtualizada);
    }
    public void excluirPorId(UUID idTelemetria){telemetriaRepository.deleteById(idTelemetria);}
}
