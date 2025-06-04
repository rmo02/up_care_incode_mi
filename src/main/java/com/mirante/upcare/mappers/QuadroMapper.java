package com.mirante.upcare.mappers;

import com.mirante.upcare.dto.request.QuadroRequest;
import com.mirante.upcare.dto.response.QuadroResponse;
import com.mirante.upcare.models.Quadro;
import com.mirante.upcare.service.QuadroService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring", uses = {EquipamentoMapper.class})
public abstract class QuadroMapper {

    @Autowired
    private QuadroService quadroService;

    @Mapping(source = "id", target = "idQuadro")
    public abstract QuadroResponse toResponse(Quadro quadro);

    public abstract Quadro toEntity(QuadroRequest request);

    public Quadro toEntity(UUID idQuadro){
        return quadroService.buscarPorId(idQuadro);
    }

    public abstract List<QuadroResponse> toResponseList(List<Quadro> quadros);
}
