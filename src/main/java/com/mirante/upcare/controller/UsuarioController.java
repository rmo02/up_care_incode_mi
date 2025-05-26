package com.mirante.upcare.controller;

import com.mirante.upcare.dto.response.UsuarioResponse;
import com.mirante.upcare.mappers.UsuarioMapper;
import com.mirante.upcare.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("Usuario")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    @GetMapping
    public List<UsuarioResponse> buscarTodos() {
        return UsuarioMapper.INSTANCE.toResponseList(
                usuarioRepository.findAll()
        );
    }
}
