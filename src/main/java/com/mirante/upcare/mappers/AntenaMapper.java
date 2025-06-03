package com.mirante.upcare.mappers;

import org.mapstruct.Mapper;

@Mapper(uses = {EquipamentoMapper.class, TransmissorMapper.class})
public interface AntenaMapper {
    // AntenaMapper INSTANCE = Mappers.getMapper(AntenaMapper.class);

    // @Mapping(source  = "id", target = "idAntena")
    // AntenaResponse toResponse(Antena antena);
    // List<AntenaResponse> toResponseList(List<Antena> antenas);
    // Antena toEntity(AntenaRequest dto);
}
