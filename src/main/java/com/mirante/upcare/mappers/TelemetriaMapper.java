package com.mirante.upcare.mappers;

import com.mirante.upcare.dto.request.TelemetriaRequest;
import com.mirante.upcare.dto.response.TelemetriaResponse;
import com.mirante.upcare.models.Telemetria;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(uses = EquipamentoMapper.class, componentModel = "spring")
public interface TelemetriaMapper {

    @Mapping(target = "id", ignore = true)
    Telemetria toEntity(TelemetriaRequest request);

    @Mapping(source = "id", target = "idTelemetria")
    TelemetriaResponse toResponse(Telemetria telemetria);
    List<TelemetriaResponse> toResponseList(List<Telemetria> telemetrias);
}
