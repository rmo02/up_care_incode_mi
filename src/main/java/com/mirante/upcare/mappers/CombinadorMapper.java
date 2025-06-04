package com.mirante.upcare.mappers;

import com.mirante.upcare.dto.request.CombinadorRequest;
import com.mirante.upcare.dto.response.CombinadorResponse;
import com.mirante.upcare.models.Combinador;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(uses = EquipamentoMapper.class, componentModel = "spring")
public interface CombinadorMapper {

    @Mapping(target = "id", ignore = true)
    Combinador toEntity(CombinadorRequest request);

    @Mapping(source = "id", target = "idCombinador")
    CombinadorResponse toResponse(Combinador combinador);
    List<CombinadorResponse> toResponseList(List<Combinador> combinadors);

}
