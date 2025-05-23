package com.mirante.upcare.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.mirante.upcare.dto.response.EmpresaResponse;
import com.mirante.upcare.models.Empresa;

import java.util.List;

@Mapper
public interface EmpresaMapper {
    
    EmpresaMapper INSTANCE = Mappers.getMapper(EmpresaMapper.class);

    @Mapping(source = "id", target = "idEmpresa")
    EmpresaResponse toResponse(Empresa empresa);

    List<EmpresaResponse> toResponseList(List<Empresa> empresas);
}
