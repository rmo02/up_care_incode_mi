package com.mirante.upcare.mappers;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import com.mirante.upcare.dto.response.CaboResponse;
import com.mirante.upcare.models.Cabo;

@Mapper(uses = EquipamentoMapper.class)
public interface CaboMapper {
    
    CaboMapper INSTANCE = Mappers.getMapper(CaboMapper.class);

    @Mapping(source = "id", target = "idCabo")
    CaboResponse toResponse(Cabo cabo);
    List<CaboResponse> toResponseList(List<Cabo> cabos);
}
