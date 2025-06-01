package com.mirante.upcare.mappers;

import com.mirante.upcare.dto.request.NobreakRequest;
import com.mirante.upcare.dto.response.NobreakResponse;
import com.mirante.upcare.models.Nobreak;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {EquipamentoMapper.class, QuadroMapper.class})
public interface NobreakMapper {

    @Mapping(source = "id", target = "idNobreak")
    NobreakResponse toResponse(Nobreak nobreak);

    Nobreak toEntity(NobreakRequest request);

    List<NobreakResponse> toResponseList(List<Nobreak> nobreaks);
}
