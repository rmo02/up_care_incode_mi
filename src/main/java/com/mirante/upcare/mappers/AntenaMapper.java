package com.mirante.upcare.mappers;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import com.mirante.upcare.dto.response.AntenaResponse;
import com.mirante.upcare.models.Antena;

@Mapper(uses = {EquipamentoMapper.class, TransmissorMapper.class})
public interface AntenaMapper {
    AntenaMapper INSTANCE = Mappers.getMapper(AntenaMapper.class);

    @Mapping(source  = "id", target = "idAntena")
    AntenaResponse toResponse(Antena antena);
    List<AntenaResponse> toResponseList(List<Antena> antenas);
}
