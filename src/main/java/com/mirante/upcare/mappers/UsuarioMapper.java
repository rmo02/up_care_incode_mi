package com.mirante.upcare.mappers;

import com.mirante.upcare.dto.request.UsuarioRequest;
import com.mirante.upcare.dto.response.UsuarioResponse;
import com.mirante.upcare.models.Usuario;
import com.mirante.upcare.service.UsuarioService;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring", uses = EmpresaMapper.class)
public abstract class UsuarioMapper {

    @Autowired
    private UsuarioService usuarioService;

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "idEmpresa", target = "empresa")
    public abstract Usuario toEntity(UsuarioRequest usuarioRequest);

    public Usuario toEntity(UUID idUsuario) {
        return usuarioService.buscarPorId(idUsuario);
    }

    @Mapping(source = "id", target = "idUsuario")
    public abstract UsuarioResponse toResponse(Usuario usuario);

    public abstract List<UsuarioResponse> toResponseList(List<Usuario> usuarios);
}
