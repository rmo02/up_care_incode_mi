package com.mirante.upcare.mappers;

import com.mirante.upcare.dto.response.CombinadorResponse;
import com.mirante.upcare.models.Combinador;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper(uses = EquipamentoMapper.class)
public interface CombinadorMapper {

    CombinadorMapper INSTANCE = Mappers.getMapper(CombinadorMapper.class);

    @Mapping(source = "id", target = "idCombinador")
    CombinadorResponse toResponse(Combinador combinador);
    List<CombinadorResponse> toResponseList(List<Combinador> combinadors);
}
