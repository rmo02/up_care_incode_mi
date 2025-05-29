package com.mirante.upcare.mappers;

import com.mirante.upcare.dto.request.EmpresaRequest;
import com.mirante.upcare.repository.EmpresaRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.mirante.upcare.dto.response.EmpresaResponse;
import com.mirante.upcare.models.Empresa;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class EmpresaMapper {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Mapping(target = "id", ignore = true)
    abstract public Empresa toEntity(EmpresaRequest empresaRequest);

    @Mapping(source = "id", target = "idEmpresa")
    abstract public EmpresaResponse toResponse(Empresa empresa);

    abstract public List<EmpresaResponse> toResponseList(List<Empresa> empresas);
}
