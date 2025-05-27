package com.mirante.upcare.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.mirante.upcare.dto.request.EstacaoRequest;
import com.mirante.upcare.dto.response.EstacaoResponse;
import com.mirante.upcare.models.Estacao;

@Mapper
public interface EstacaoMapper {
    
    EstacaoMapper INSTANCE = Mappers.getMapper(EstacaoMapper.class);

    Estacao toEntity(EstacaoRequest estacaoRequest);

    @Mapping(source = "id", target = "idEstacao")
    EstacaoResponse toResponse(Estacao estacao);

    List<EstacaoResponse> toResponseList(List<Estacao> estacoes);
}
