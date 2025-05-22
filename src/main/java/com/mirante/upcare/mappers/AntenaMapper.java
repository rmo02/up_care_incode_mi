package com.mirante.upcare.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AntenaMapper {
    AntenaMapper INSTANCE = Mappers.getMapper(AntenaMapper.class);
}
