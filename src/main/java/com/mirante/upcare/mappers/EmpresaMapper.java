package com.mirante.upcare.mappers;

import java.util.List;
import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.mirante.upcare.dto.request.EmpresaRequest;
import com.mirante.upcare.dto.response.EmpresaResponse;
import com.mirante.upcare.models.Empresa;
import com.mirante.upcare.service.EmpresaService;

@Mapper(componentModel = "spring")
public abstract class EmpresaMapper {

    @Autowired
    private EmpresaService empresaService;

    @Mapping(target = "id", ignore = true)
    public abstract Empresa toEntity(EmpresaRequest empresaRequest);

    public Empresa toEntity(UUID idEmpresa) {
        return empresaService.buscarPorId(idEmpresa);
    }

    @Mapping(source = "id", target = "idEmpresa")
    public abstract EmpresaResponse toResponse(Empresa empresa);

    public abstract List<EmpresaResponse> toResponseList(List<Empresa> empresas);
}
