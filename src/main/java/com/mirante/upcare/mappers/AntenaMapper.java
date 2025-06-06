package com.mirante.upcare.mappers;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.mirante.upcare.dto.request.AntenaRequest;
import com.mirante.upcare.dto.response.AntenaResponse;
import com.mirante.upcare.models.Antena;

@Mapper(componentModel = "spring", uses = {EquipamentoMapper.class, TransmissorMapper.class})
public interface AntenaMapper {
    
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "idTransmissor", target = "transmissor")
    Antena toEntity(AntenaRequest dto);
    
    @Mapping(source  = "id", target = "idAntena")
    AntenaResponse toResponse(Antena antena);

    List<AntenaResponse> toResponseList(List<Antena> antenas);
}
