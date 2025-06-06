package com.mirante.upcare.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.mirante.upcare.dto.request.ReceptorRequest;
import com.mirante.upcare.dto.response.ReceptorResponse;
import com.mirante.upcare.models.Receptor;

@Mapper(componentModel = "spring", uses = {EquipamentoMapper.class, ParabolicaMapper.class, TransmissorMapper.class})
public interface ReceptorMapper {
    
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "idParabolica", target = "parabolica")
    @Mapping(source = "idTransmissor", target = "transmissor")
    Receptor toEntity(ReceptorRequest dto);
    
    @Mapping(source  = "id", target = "idReceptor")
    ReceptorResponse toResponse(Receptor receptor);

    List<ReceptorResponse> toResponseList(List<Receptor> receptores);
} 