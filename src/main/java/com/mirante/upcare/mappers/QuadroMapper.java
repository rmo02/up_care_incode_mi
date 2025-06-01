package com.mirante.upcare.mappers;

import com.mirante.upcare.dto.request.QuadroRequest;
import com.mirante.upcare.dto.response.QuadroResponse;
import com.mirante.upcare.models.Quadro;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {EquipamentoMapper.class})
public interface QuadroMapper {

    @Mapping(source = "id", target = "idQuadro")
    QuadroResponse toResponse(Quadro quadro);

    Quadro toEntity(QuadroRequest request);

    List<QuadroResponse> toResponseList(List<Quadro> quadros);
}
