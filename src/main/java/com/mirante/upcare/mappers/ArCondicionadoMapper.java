package com.mirante.upcare.mappers;

import com.mirante.upcare.dto.response.ArCondicionadoResponse;
import com.mirante.upcare.models.ArCondicionado;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper(uses = EquipamentoMapper.class)
public interface ArCondicionadoMapper {

    ArCondicionadoMapper INSTANCE = Mappers.getMapper(ArCondicionadoMapper.class);

    @Mapping(source = "id", target = "idArcondicionado")
    ArCondicionadoResponse toResponse(ArCondicionado arCondicionado);
    List<ArCondicionadoResponse> toResponseList(List<ArCondicionado> arCondicionados);
}
