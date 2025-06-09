package com.mirante.upcare.mappers;

import com.mirante.upcare.dto.request.CaboRequest;
import com.mirante.upcare.dto.response.CaboResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.mirante.upcare.models.Cabo;
import java.util.List;

@Mapper(uses = EquipamentoMapper.class, componentModel = "spring")
public interface CaboMapper {

    @Mapping(target = "id", ignore = true)
    Cabo toEntity(CaboRequest request);

    @Mapping(source = "id", target = "idCabo")
    CaboResponse toResponse(Cabo cabo);
    List<CaboResponse> toResponseList(List<Cabo> cabos);
}
