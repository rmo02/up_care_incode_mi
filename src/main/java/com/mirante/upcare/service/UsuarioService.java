package com.mirante.upcare.service;

import com.mirante.upcare.models.Usuario;
import com.mirante.upcare.repository.UsuarioRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
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
        return usuarioRepository.findById(idUsuario).orElseThrow();
    }
    public void deletarPorId(UUID idUsuario){
        usuarioRepository.deleteById(idUsuario);
    }
}
