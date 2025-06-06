package com.mirante.upcare.mappers;

import java.util.List;
import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.mirante.upcare.dto.request.ParabolicaRequest;
import com.mirante.upcare.dto.response.ParabolicaResponse;
import com.mirante.upcare.models.Parabolica;
import com.mirante.upcare.service.ParabolicaService;

@Mapper(componentModel = "spring", uses = EquipamentoMapper.class)
public abstract class ParabolicaMapper {

    @Autowired
    private ParabolicaService parabolicaService;

    @Mapping(source = "id", target = "idParabolica")
    public abstract ParabolicaResponse toResponse(Parabolica parabolica);

    @Mapping(target = "id", ignore = true)
    public abstract Parabolica toEntity(ParabolicaRequest parabolicaRequest);

    public Parabolica toEntity(UUID idParabolica) {
        return parabolicaService.buscarPorId(idParabolica);
    }
    
    public abstract List<ParabolicaResponse> toResponseList(List<Parabolica> parabolicas);
}
