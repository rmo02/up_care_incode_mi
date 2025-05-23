package com.mirante.upcare.mappers;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import com.mirante.upcare.dto.response.ParabolicaResponse;
import com.mirante.upcare.models.Parabolica;

@Mapper(uses = EquipamentoMapper.class)
public interface ParabolicaMapper {

    ParabolicaMapper INSTANCE = Mappers.getMapper(ParabolicaMapper.class);
    
    @Mapping(source  = "id", target = "idParabolica")
    ParabolicaResponse toResponse(Parabolica parabolica);
    List<ParabolicaResponse> toResponseList(List<Parabolica> parabolicas);
}
