package com.mirante.upcare.mappers;

import java.util.List;
import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.mirante.upcare.dto.request.ManutencaoRequest;
import com.mirante.upcare.dto.response.ManutencaoResponse;
import com.mirante.upcare.models.Manutencao;
import com.mirante.upcare.service.ManutencaoService;

@Mapper(componentModel = "spring", uses = {UsuarioMapper.class, EstacaoMapper.class})
public abstract class ManutencaoMapper {

    @Autowired
    private ManutencaoService manutencaoService;

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "idEstacao", target = "estacao")
    @Mapping(source = "idTecnico", target = "tecnico")
    public abstract Manutencao toEntity(ManutencaoRequest manutencaoRequest);

    public Manutencao toEntity(UUID idManutencao) {
        return manutencaoService.buscarPorId(idManutencao);
    }

    @Mapping(source = "id", target = "idManutencao")
    public abstract ManutencaoResponse toResponse(Manutencao manutencao);

    public abstract List<ManutencaoResponse> toResponseList(List<Manutencao> manutencaos);

}
