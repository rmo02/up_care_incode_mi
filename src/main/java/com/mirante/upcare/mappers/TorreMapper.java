package com.mirante.upcare.mappers;

import com.mirante.upcare.dto.request.TorreRequest;
import com.mirante.upcare.dto.response.TorreResponse;
import com.mirante.upcare.models.Torre;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(uses = EquipamentoMapper.class, componentModel = "spring")
public interface TorreMapper {

    @Mapping(target = "id", ignore = true)
    Torre toEntity(TorreRequest request);

    @Mapping(source = "id", target = "idTorre")
    TorreResponse toResponse(Torre torre);
    List<TorreResponse> toResponseList(List<Torre> torres);

}
