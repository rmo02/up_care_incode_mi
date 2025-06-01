package com.mirante.upcare.mappers;

import com.mirante.upcare.dto.request.DpsRequest;
import com.mirante.upcare.dto.response.DpsResponse;
import com.mirante.upcare.models.Dps;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {EquipamentoMapper.class, QuadroMapper.class})
public interface DpsMapper {

    @Mapping(source = "id", target = "idDps")
    DpsResponse toResponse(Dps dps);

    Dps toEntity(DpsRequest request);

    List<DpsResponse> toResponseList(List<Dps> dpsList);
}
