package com.mirante.upcare.mappers;

import com.mirante.upcare.dto.request.SwitchRequest;
import com.mirante.upcare.dto.response.SwitchResponse;
import com.mirante.upcare.models.Switch;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {EquipamentoMapper.class, QuadroMapper.class})
public interface SwitchMapper {

    @Mapping(source = "id", target = "idSwitch")
    SwitchResponse toResponse(Switch entity);

    Switch toEntity(SwitchRequest request);

    List<SwitchResponse> toResponseList(List<Switch> entities);
}
