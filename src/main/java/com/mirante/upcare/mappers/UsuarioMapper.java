package com.mirante.upcare.mappers;

import com.mirante.upcare.dto.request.UsuarioRequest;
import com.mirante.upcare.dto.response.UsuarioResponse;
import com.mirante.upcare.models.Usuario;
import com.mirante.upcare.repository.UsuarioRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring", uses = EmpresaMapper.class)
public abstract class UsuarioMapper {


    @Autowired
    private UsuarioRepository usuarioRepository;

    @Mapping(target = "id", ignore = true)
    abstract public Usuario toEntity(UsuarioRequest usuarioRequest);


    @Mapping(source = "id", target = "idUsuario")
    abstract public UsuarioResponse toResponse(Usuario usuario);

    abstract public List<UsuarioResponse> toResponseList(List<Usuario> usuarios);


}
