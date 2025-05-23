package com.mirante.upcare.mappers;

import com.mirante.upcare.dto.response.UsuarioResponse;
import com.mirante.upcare.models.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper(uses = EmpresaMapper.class)
public interface UsuarioMapper {

   UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    @Mapping(source = "id", target = "idUsuario")
    UsuarioResponse toResponse(Usuario usuario);

    List<UsuarioResponse> toResponseList(List<Usuario> usuarios);

}
