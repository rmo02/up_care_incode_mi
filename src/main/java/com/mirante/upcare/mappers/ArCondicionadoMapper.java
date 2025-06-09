package com.mirante.upcare.mappers;

import com.mirante.upcare.dto.response.ArCondicionadoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.mirante.upcare.dto.request.ArCondionadoRequest;
import com.mirante.upcare.models.ArCondicionado;
import java.util.List;

@Mapper(uses = EquipamentoMapper.class, componentModel = "spring")
public interface ArCondicionadoMapper {

    @Mapping(target = "id", ignore = true)
    ArCondicionado toEntity(ArCondionadoRequest request);

    @Mapping(source = "id", target = "idArCondicionado")
    ArCondicionadoResponse toResponse(ArCondicionado arCondicionado);
    List<ArCondicionadoResponse> toResponseList(List<ArCondicionado> arCondicionados);
}