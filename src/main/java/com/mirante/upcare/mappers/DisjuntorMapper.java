package com.mirante.upcare.mappers;

import com.mirante.upcare.dto.request.DisjuntorRequest;
import com.mirante.upcare.dto.response.DisjuntorResponse;
import com.mirante.upcare.models.Disjuntor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {EquipamentoMapper.class, QuadroMapper.class})
public interface DisjuntorMapper {

    @Mapping(source = "id", target = "idDisjuntor")
    DisjuntorResponse toResponse(Disjuntor disjuntor);

    @Mapping(source = "idQuadro", target = "quadro")
    Disjuntor toEntity(DisjuntorRequest request);

    List<DisjuntorResponse> toResponseList(List<Disjuntor> disjuntores);
}
