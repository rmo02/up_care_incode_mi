package com.mirante.upcare.mappers;

import com.mirante.upcare.dto.response.ManutencaoResponse;
import com.mirante.upcare.models.Manutencao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {UsuarioMapper.class, EstacaoMapper.class})
public interface ManutencaoMapper {

    ManutencaoMapper INSTANCE = Mappers.getMapper(ManutencaoMapper.class);

    @Mapping(source = "id", target = "idManutencao")
    ManutencaoResponse toResponse(Manutencao manutencao);

    List<ManutencaoResponse> toResponseList(List<Manutencao> manutencaos);


}
