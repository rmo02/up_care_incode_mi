package com.mirante.upcare.mappers;

import java.util.List;
import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.mirante.upcare.dto.request.EstacaoRequest;
import com.mirante.upcare.dto.response.EstacaoResponse;
import com.mirante.upcare.models.Estacao;
import com.mirante.upcare.service.EstacaoService;

@Mapper(componentModel = "spring")
public abstract class EstacaoMapper {
    
    @Autowired
    private EstacaoService estacaoService;

    @Mapping(target = "id", ignore = true)
    abstract public Estacao toEntity(EstacaoRequest estacaoRequest);

    public Estacao toEntity(UUID idEstacao) {
        return estacaoService.buscarPorId(idEstacao);
    }

    @Mapping(source = "id", target = "idEstacao")
    abstract public EstacaoResponse toResponse(Estacao estacao);
    
    abstract public List<EstacaoResponse> toResponseList(List<Estacao> estacoes);
}
