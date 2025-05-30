package com.mirante.upcare.mappers;

import com.mirante.upcare.dto.response.TorreResponse;
import com.mirante.upcare.models.Torre;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper(uses = EquipamentoMapper.class)
public interface TorreMapper {

    TorreMapper INSTANCE = Mappers.getMapper(TorreMapper.class);

    @Mapping(source = "id", target = "idTorre")
    TorreResponse toResponse(Torre torre);
    List<TorreResponse> toResponseList(List<Torre> torres);

}
