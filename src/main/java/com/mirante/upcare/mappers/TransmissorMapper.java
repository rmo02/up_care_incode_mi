package com.mirante.upcare.mappers;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import com.mirante.upcare.dto.response.TransmissorResponse;
import com.mirante.upcare.models.Transmissor;

@Mapper(uses = EquipamentoMapper.class)
public interface TransmissorMapper {

    TransmissorMapper INSTANCE = Mappers.getMapper(TransmissorMapper.class);

    @Mapping(source  = "id", target = "idTransmissor")
    TransmissorResponse toResponse(Transmissor transmissor);
    List<TransmissorResponse> toResponseList(List<Transmissor> transmissores);
}