package com.mirante.upcare.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mirante.upcare.dto.request.UsuarioRequest;
import com.mirante.upcare.dto.response.UsuarioResponse;
import com.mirante.upcare.mappers.UsuarioMapper;
import com.mirante.upcare.service.UsuarioService;
import com.mirante.upcare.utils.Pipeline;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final UsuarioMapper usuarioMapper;

    @PostMapping
    public ResponseEntity<Object> salvar(@RequestBody @Valid UsuarioRequest dto){
        return (Pipeline
            .from(dto)
            .then(usuarioMapper::toEntity)
            .then(usuarioService::salvar)
            .then(u -> ResponseEntity.status(HttpStatus.CREATED).build())
            .get()
        );
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> buscarTodos(){
        return (Pipeline
            .from(usuarioService.buscarTodos())
            .then(usuarioMapper::toResponseList)
            .then(ResponseEntity::ok)
            .get()
        );
    }

    @GetMapping("{idUsuario}")
    public ResponseEntity<UsuarioResponse> buscarPorId(@PathVariable UUID idUsuario) {
        return (Pipeline
            .from(idUsuario)
            .then(usuarioService::buscarPorId)
            .then(usuarioMapper::toResponse)
            .then(ResponseEntity::ok)
            .get()
        );
    }

    @PutMapping("{idUsuario}")
    public ResponseEntity<Object> atualizarPorId(@PathVariable UUID idUsuario, @Valid @RequestBody UsuarioRequest dto) {
        return (Pipeline
            .from(dto)
            .then(usuarioMapper::toEntity)
            .then(usuarioAtualizado -> usuarioService.atualizarPorId(idUsuario, usuarioAtualizado))
            .then(u -> ResponseEntity.noContent().build())
            .get()
        );
    }

    @DeleteMapping("{idUsuario}")
    public ResponseEntity<Object> deletarPorId(@PathVariable UUID idUsuario) {
        usuarioService.deletarPorId(idUsuario);
        return ResponseEntity.noContent().build();
    }
}
