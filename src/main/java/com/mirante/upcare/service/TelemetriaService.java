package com.mirante.upcare.service;

import com.mirante.upcare.exceptions.NotFoundException;
import com.mirante.upcare.models.Telemetria;
import com.mirante.upcare.repository.TelemetriaRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TelemetriaService {
    private final TelemetriaRepository telemetriaRepository;

    public Telemetria salvar(@Valid Telemetria telemetria) {return telemetriaRepository.save(telemetria);}
    public List<Telemetria> buscarTodos(){return telemetriaRepository.findAll();}
    public Telemetria buscarPorId(UUID idTelemetria){return telemetriaRepository.findById(idTelemetria).orElseThrow(
            () -> new NotFoundException("Telemetria não encontrada com o ID: " + idTelemetria)
    );}
    public Telemetria AtualizarPorId(UUID idTelemetria, @Valid Telemetria telemetriaAtualizada){
        Telemetria telemetriaExistente = buscarPorId(idTelemetria);
        BeanUtils.copyProperties(telemetriaAtualizada, telemetriaExistente, "id");
        return salvar(telemetriaExistente);
    }
    public void excluirPorId(UUID idTelemetria){
        buscarPorId(idTelemetria);
        telemetriaRepository.deleteById(idTelemetria);}
}
