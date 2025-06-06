package com.mirante.upcare.mappers;

import java.util.List;
import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.mirante.upcare.dto.request.TransmissorRequest;
import com.mirante.upcare.dto.response.TransmissorResponse;
import com.mirante.upcare.models.Transmissor;
import com.mirante.upcare.service.TransmissorService;

@Mapper(componentModel = "spring" , uses = EquipamentoMapper.class)
public abstract class TransmissorMapper {

    @Autowired
    private TransmissorService transmissorService;

    @Mapping(source = "id", target = "idTransmissor")
    public abstract TransmissorResponse toResponse(Transmissor transmissor);

    @Mapping(target = "id", ignore = true)
    public abstract Transmissor toEntity(TransmissorRequest transmissorRequest);

    public Transmissor toEntity(UUID idTransmissor) {
        return transmissorService.buscarPorId(idTransmissor);
    }
    
    public abstract List<TransmissorResponse> toResponseList(List<Transmissor> transmissores);
}