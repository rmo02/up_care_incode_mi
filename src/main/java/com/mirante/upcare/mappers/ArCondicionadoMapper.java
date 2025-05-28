package com.mirante.upcare.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.mirante.upcare.dto.request.ArCondionadoRequest;
import com.mirante.upcare.models.ArCondicionado;

@Mapper(uses = EquipamentoMapper.class, componentModel = "spring")
public abstract class ArCondicionadoMapper {

    @Mapping(target = "id", ignore = true)
    public abstract ArCondicionado toEntity(ArCondionadoRequest dto);
}
