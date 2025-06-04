package com.mirante.upcare.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.mirante.upcare.dto.request.TransmissorRequest;
import com.mirante.upcare.dto.response.TransmissorResponse;
import com.mirante.upcare.models.Transmissor;

@Mapper(componentModel = "spring" , uses = EquipamentoMapper.class)
public interface TransmissorMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "equipamento", target = "equipamento")  
    Transmissor toEntity(TransmissorRequest dto);

    @Mapping(source = "id", target = "idTransmissor")
    TransmissorResponse toResponse(Transmissor transmissor);
    List<TransmissorResponse> toResponseList(List<Transmissor> transmissores);
}