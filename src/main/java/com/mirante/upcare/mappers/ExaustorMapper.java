package com.mirante.upcare.mappers;

import com.mirante.upcare.dto.response.ExaustorResponse;
import com.mirante.upcare.models.Exaustor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper(uses = EquipamentoMapper.class)
public interface ExaustorMapper {

    ExaustorMapper INSTANCE = Mappers.getMapper(ExaustorMapper.class);

    @Mapping(source = "id", target = "idExaustor")
    ExaustorResponse toResponse(Exaustor exaustor);
    List<ExaustorResponse> toResponseList(List<Exaustor> exaustors);

}
