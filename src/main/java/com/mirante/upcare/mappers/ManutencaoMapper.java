package com.mirante.upcare.mappers;

import com.mirante.upcare.dto.request.ManutencaoRequest;
import com.mirante.upcare.dto.response.ManutencaoResponse;
import com.mirante.upcare.models.Manutencao;
import com.mirante.upcare.repository.ManutencaoRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UsuarioMapper.class, EstacaoMapper.class})
public abstract class ManutencaoMapper {

    @Autowired
    private ManutencaoRepository manutencaoRepository;

    @Mapping(target = "id", ignore = true)
    abstract public Manutencao toEntity(ManutencaoRequest manutencaoRequest);

    @Mapping(source = "id", target = "idManutencao")
    abstract public ManutencaoResponse toResponse(Manutencao manutencao);

    abstract public List<ManutencaoResponse> toResponseList(List<Manutencao> manutencaos);

}
