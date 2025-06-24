package com.mirante.upcare.service;

import com.mirante.upcare.exceptions.NotFoundException;
import com.mirante.upcare.models.Usuario;
import com.mirante.upcare.repository.UsuarioRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public Usuario salvar(@Valid Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> buscarTodos(){
        return usuarioRepository.findAll();
    }

    public Usuario buscarPorId(UUID idUsuario){
        return usuarioRepository.findById(idUsuario).orElseThrow(
            () -> new NotFoundException("Usuário não encontrada com o ID: " + idUsuario)
        );
    }

    public void deletarPorId(UUID idUsuario){
        buscarPorId(idUsuario);
        usuarioRepository.deleteById(idUsuario);
    }

    public Usuario atualizarPorId(UUID idUsuario, @Valid Usuario usuarioAtualizado) {
        Usuario usuarioExistente = buscarPorId(idUsuario);
        BeanUtils.copyProperties(usuarioAtualizado, usuarioExistente, "id");
        return salvar(usuarioExistente);
    }
}
