package com.mirante.upcare.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.mirante.upcare.dto.response.ReceptorResponse;
import com.mirante.upcare.models.Receptor;

@Mapper(uses = {EquipamentoMapper.class, TransmissorMapper.class, ParabolicaMapper.class})
public interface ReceptorMapper {

    ReceptorMapper INSTANCE = Mappers.getMapper(ReceptorMapper.class);
    
    @Mapping(source  = "id", target = "idReceptor")
    ReceptorResponse tResponse(Receptor receptor);
} 