package com.mirante.upcare.mappers;

import com.mirante.upcare.dto.request.ExaustorRequest;
import com.mirante.upcare.dto.response.ExaustorResponse;
import com.mirante.upcare.models.Exaustor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(uses = EquipamentoMapper.class, componentModel = "spring")
public interface ExaustorMapper {

    @Mapping(target = "id", ignore = true)
    Exaustor toEntity(ExaustorRequest request);

    @Mapping(source = "id", target = "idExaustor")
    ExaustorResponse toResponse(Exaustor exaustor);
    List<ExaustorResponse> toResponseList(List<Exaustor> exaustors);

}
