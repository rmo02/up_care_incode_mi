package com.mirante.upcare.mappers;


import com.mirante.upcare.dto.response.TelemetriaResponse;
import com.mirante.upcare.models.Telemetria;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper(uses = EquipamentoMapper.class)
public interface TelemetriaMapper {

    TelemetriaMapper INSTANCE = Mappers.getMapper(TelemetriaMapper.class);

    @Mapping(source = "id", target = "idTelemetria")
    TelemetriaResponse toResponse(Telemetria telemetria);
    List<TelemetriaResponse> toResponseList(List<Telemetria> telemetrias);
}
