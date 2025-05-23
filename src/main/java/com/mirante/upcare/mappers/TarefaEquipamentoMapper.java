package com.mirante.upcare.mappers;
import com.mirante.upcare.dto.response.TarefaEquipamentoResponse;
import com.mirante.upcare.models.TarefaEquipamento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper(uses = {EquipamentoMapper.class, TarefaMapper.class})
public interface TarefaEquipamentoMapper {

    TarefaEquipamentoMapper INSTANCE = Mappers.getMapper(TarefaEquipamentoMapper.class);

    @Mapping(source = "id", target = "idTarefaEquipamento")
    TarefaEquipamentoResponse toResponse(TarefaEquipamento tarefaEquipamento);

    List<TarefaEquipamentoResponse> toResponseList(List<TarefaEquipamento> tarefaEquipamentos);

}
