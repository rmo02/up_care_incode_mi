package com.mirante.upcare.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.mirante.upcare.dto.request.DisjuntorRequest;
import com.mirante.upcare.dto.response.DisjuntorResponse;
import com.mirante.upcare.models.Disjuntor;

@Mapper(componentModel = "spring", uses = {EquipamentoMapper.class, QuadroMapper.class})
public interface DisjuntorMapper {

    @Mapping(source = "id", target = "idDisjuntor")
    DisjuntorResponse toResponse(Disjuntor disjuntor);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "idQuadro", target = "quadro")
    Disjuntor toEntity(DisjuntorRequest request);

    List<DisjuntorResponse> toResponseList(List<Disjuntor> disjuntores);
}
