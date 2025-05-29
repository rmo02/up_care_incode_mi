package com.mirante.upcare.mappers;
import com.mirante.upcare.dto.request.TarefaEquipamentoRequest;
import com.mirante.upcare.dto.response.TarefaEquipamentoResponse;
import com.mirante.upcare.models.TarefaEquipamento;
import com.mirante.upcare.repository.TarefaEquipamentoRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring", uses = {EquipamentoMapper.class, TarefaMapper.class})
public abstract class TarefaEquipamentoMapper {

    @Autowired
    private TarefaEquipamentoRepository tarefaEquipamentoRepository;

    @Mapping(target = "id", ignore = true)
    abstract public TarefaEquipamento toEntity(TarefaEquipamentoRequest tarefaEquipamentoRequest);

    @Mapping(source = "id", target = "idTarefaEquipamento")
    abstract public TarefaEquipamentoResponse toResponse(TarefaEquipamento tarefaEquipamento);

    abstract public List<TarefaEquipamentoResponse> toResponseList(List<TarefaEquipamento> tarefaEquipamentos);

}
