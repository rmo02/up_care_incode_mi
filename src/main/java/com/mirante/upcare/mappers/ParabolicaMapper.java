package com.mirante.upcare.mappers;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.mirante.upcare.dto.request.ParabolicaRequest;
import com.mirante.upcare.dto.response.ParabolicaResponse;
import com.mirante.upcare.models.Parabolica;

@Mapper(componentModel = "spring", uses = EquipamentoMapper.class)
public interface ParabolicaMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "equipamento", target = "equipamento")  
    Parabolica toEntity(ParabolicaRequest dto);
    
    @Mapping(source  = "id", target = "idParabolica")
    ParabolicaResponse toResponse(Parabolica parabolica);
    List<ParabolicaResponse> toResponseList(List<Parabolica> parabolicas);
}
